plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.ksp)
    alias(libs.plugins.paparazzi)
}

android {
    namespace = "sobaya.app.screenshotTest"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

androidComponents {
    beforeVariants(selector().withBuildType("release")) { builder ->
        builder.enable = false
    }
}

dependencies {
    implementation(libs.bundles.compose)
    implementation(libs.showkase)
    ksp(libs.showkaseProcessor)

    testImplementation(libs.junit)
    testImplementation(libs.testParameterInjector)
}

tasks.named("check") {
    dependsOn("verifyPaparazziDemoDebug")
}

tasks.withType<Test>().configureEach {
    // Increase memory for Paparazzi tests
    maxHeapSize = "2g"
}
