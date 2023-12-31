@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.agp.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
    id(libs.plugins.hilt.android.get().pluginId)
}

android {
    namespace = "com.example.ecomarket"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ecomarket"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
    hilt {
        enableAggregatingTask = true
    }
}

dependencies {
    implementation(project(":features:main"))
    implementation(project(":features:basket"))
    implementation(project(":features:story"))
    implementation(project(":features:info"))
    implementation(project(":data"))
    implementation(project(":core:ui"))

    implementation(libs.androidx.core)

    //Bundles
    implementation(libs.bundles.ui)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.navigation)

    //Test
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.test.espresso)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
}