plugins {
    // trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.2").apply(false)
    kotlin("multiplatform").version("1.7.10").apply(false)
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
    id("com.squareup.sqldelight") version "1.5.4" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.googleService)
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
