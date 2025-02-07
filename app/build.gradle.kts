plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
//    id("kotlin-kapt")

    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")


}

android {
    namespace = "com.example.onlyofficeclient"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.onlyofficeclient"
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

    viewBinding {
        enable = true
    }

}

dependencies {

    // Navigation Components
    implementation (libs.androidx.navigation.fragment.ktx.v242)
    implementation (libs.androidx.navigation.ui.ktx.v242)


//    //Hilt
//    implementation ("com.google.dagger:hilt-android:$2.41")
//    kapt ("com.google.dagger:hilt-compiler:$2.41")
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")



//    implementation("androidx.navigation:navigation-compose:$nav_version")
//
//    implementation("androidx.navigation:navigation-fragment:$nav_version")
//    implementation("androidx.navigation:navigation-ui:$nav_version")
//
//    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")
//
//    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")


    implementation (libs.picasso)

    implementation (libs.logging.interceptor)
    implementation (libs.okhttp)

    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}