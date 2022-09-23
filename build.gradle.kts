plugins {
    // trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.0-alpha10").apply(false)
    id("com.android.library").version("7.4.0-alpha10").apply(false)
    kotlin("android").version("1.7.10").apply(false)
    kotlin("multiplatform").version("1.7.10").apply(false)
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {}
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
