plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //alias(libs.plugins.hilt.android) // Hilt DI plugin
    //alias(libs.plugins.kotlin.kapt)  // Kotlin Annotation Processor for Hilt
}

android {
    namespace = "com.example.sumitapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sumitapi"
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
        viewBinding = true // enables view binding
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.retrofit) // Retrofit for API calls
    implementation(libs.gson.converter) // Gson converter for Retrofit
    implementation(libs.recyclerview) // RecyclerView
    //implementation(libs.hilt.android) // Hilt for Dependency Injection
   // kapt(libs.hilt.android-compiler) // Kotlin Annotation Processor for Hilt
    implementation(libs.navigation.fragment) // Navigation Component
    implementation(libs.navigation.ui) // Navigation UI
}
