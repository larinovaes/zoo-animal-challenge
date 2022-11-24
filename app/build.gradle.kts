plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "br.com.playground.animals"
    compileSdk = 33

    defaultConfig {
        applicationId = "br.com.playground.animals"
        minSdk = 23
        targetSdk = 33
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
}

dependencies {
    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.VIEW_MODEL_KTX)
    implementation(Dependencies.UI.MATERIAL_DESIGN)
    implementation(Dependencies.UI.COIL_KTX)
    implementation(Dependencies.UI.SWIPE_REFRESH)
    implementation(Dependencies.DI.KOIN)
    implementation(Dependencies.DataSource.RETROFIT)
    implementation(Dependencies.DataSource.RETROFIT_CONVERTER)
    implementation(Dependencies.DataSource.MOSHI)
    implementation(Dependencies.DataSource.MOSHI_KOTLIN)
    implementation(Dependencies.DataSource.MOSHI_KOTLIN_CODEGEN)
    implementation(Dependencies.DataSource.ROOM)
    kapt(Dependencies.DataSource.ROOM_COMPILER)

    testImplementation(Dependencies.UnitTest.JUNIT)
    testImplementation(Dependencies.UnitTest.MOCKK)
    testImplementation(Dependencies.UnitTest.COROUTINES_TEST)
    testImplementation(Dependencies.UnitTest.CORE_TESTING)
}
