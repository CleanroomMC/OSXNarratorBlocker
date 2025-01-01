package com.cleanroommc.osxnarratorblocker.mixin;

import com.cleanroommc.osxnarratorblocker.Tags;
import com.mojang.text2speech.NarratorDummy;
import com.sun.jna.Platform;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.mojang.text2speech.Narrator;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Thanks to Integer Limit over at NomiLabs!
@SuppressWarnings("PublicStaticMixinMember")
@Mixin(value = Narrator.class, remap = false)
public interface NarratorMixin {

    @Inject(method = "getNarrator", at = @At("HEAD"), cancellable = true)
    static void getNarrator(CallbackInfoReturnable<Narrator> cir) {
        if (Platform.isMac() && "aarch64".equals(Platform.ARCH)) {
            LogManager.getLogger(Tags.MOD_NAME).info("Disabling narrator due to currently missing natives.");
            cir.setReturnValue(new NarratorDummy());
        }
    }

}