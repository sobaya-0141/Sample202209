plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "sobaya.lib.randomdog"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    lint {
        disable.add("DialogFragmentCallbacksDetector")
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":usecase"))
    implementation(project(":util"))
    implementation(project(":local"))
    implementation(project(":features"))

    implementation(libs.core.ktx)
    implementation(libs.material)
    implementation(libs.appcompat)
    implementation(libs.kotlinxCoroutinesAndroid)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycleCompose)
    implementation(libs.coil.compose)
    implementation(libs.bundles.accompanist.pager)
    implementation(libs.bundles.compose.navigastion)
    implementation(libs.bundles.paging)

    implementation(libs.koinAndroid)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.android.test)
}
