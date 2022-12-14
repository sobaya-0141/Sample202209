plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.google.devtools.ksp") version "1.7.10-1.0.6"
}

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "network"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":data"))
                implementation(libs.ktorFitLib)
                implementation(libs.koin)
                implementation(libs.ktorNegotiation)
                implementation(libs.ktorSerialization)
                implementation(libs.ktorLogging)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
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
    namespace = "sobaya.app.network"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.kspKtorfit)
    add("kspAndroid", libs.kspKtorfit)
    add("kspIosX64", libs.kspKtorfit)
    add("kspIosArm64", libs.kspKtorfit)
    add("kspIosSimulatorArm64", libs.kspKtorfit)
}
