plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "br.com.fabriciocurvello.appdiariohumorroom"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.com.fabriciocurvello.appdiariohumorroom"
        minSdk = 28
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Adicionando o Room
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler) // Para processar as anotações
    implementation(libs.room.ktx) // Extensões KTX do Room (opcional)
}

