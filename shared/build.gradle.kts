import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.7.10"
    id("org.jlleitschuh.gradle.ktlint")
    id("com.squareup.sqldelight")
    id("com.google.devtools.ksp") version "1.7.10-1.0.6"
}

kotlin {
    val xcf = XCFramework()
    android()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            xcf.add(this)
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin)
                implementation(libs.coroutinesCore)
                implementation(libs.sqldelightFlow)
                implementation(libs.kotlinxSerializationJson)
                api(libs.bundles.mvvm)
                implementation(libs.coroutinesCore)
                implementation(libs.ktorNegotiation)
                implementation(libs.ktorSerialization)
                implementation(libs.ktorLogging)
                implementation(libs.ktorFitLib)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.composeUi)
                api(libs.mvvmFlowCompose)
                api(libs.sqldelightAndroid)
                implementation(libs.koinAndroid)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "sobaya.app.sample202209"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "sobaya.lib.local"
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.kspCommonMainMetadata)
    add("kspAndroid", libs.kspAndroid)
}
