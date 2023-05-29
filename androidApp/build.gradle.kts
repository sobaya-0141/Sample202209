plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
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
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }
    lint {
        disable.add("DialogFragmentCallbacksDetector")
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":data"))
    implementation(project(":usecase"))
    implementation(project(":util"))
    implementation(project(":androidFeatures"))
    implementation(project(":local"))
    implementation(project(":features"))

    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.core.ktx)
    implementation(libs.material)
    implementation(libs.appcompat)
    implementation(libs.kotlinxCoroutinesAndroid)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)
    implementation(libs.coil.compose)
    implementation(libs.bundles.accompanist.pager)
    implementation(libs.bundles.compose.navigastion)

    implementation(libs.koinAndroid)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.android.test)

    implementation(platform(libs.firebaseBom))

    implementation("androidx.security:security-crypto:1.0.0")

    // For Identity Credential APIs
    implementation("androidx.security:security-identity-credential:1.0.0-alpha03")

    // For App Authentication APIs
    implementation("androidx.security:security-app-authenticator:1.0.0-alpha02")

    // For App Authentication API testing
    androidTestImplementation("androidx.security:security-app-authenticator:1.0.0-alpha01")
}
