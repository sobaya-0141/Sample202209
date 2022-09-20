plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "sobaya.app.sample202209.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "sobaya.app.sample202209.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(libs.core.ktx)
    implementation(libs.material)
    implementation(libs.appcompat)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.bundles.compose)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.bundles.hilt)
    kapt(libs.hilt.compiler)
    implementation(libs.coil.compose)
    implementation(libs.bundles.accompanist.pager)
    implementation(libs.bundles.compose.navigastion)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.android.test)
}