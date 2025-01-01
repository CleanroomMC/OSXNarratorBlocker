## OSX Narrator Blocker

This is intended purely for developers running with M1+ (OSX ARM64) Macs. Where `java-objc-bridge` natives are missing.

### Usage:

Add the following dependency in `build.gradle`
```java
repositories {
    maven {
        name 'CleanroomMC Maven'
        url 'https://maven.cleanroommc.com'
    }
}

dependencies {
    runtimeOnly 'com.cleanroommc:osxnarratorblocker:1.0'
}
```