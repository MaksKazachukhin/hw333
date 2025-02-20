plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "kg.geeks.hw33"
    compileSdk = 35

    defaultConfig {
        applicationId = "kg.geeks.hw33"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}
 val nav_version = "2.8.6"

dependencies {
    dependencies {
        // Jetpack Compose BOM (автоматически подбирает совместимые версии)
        implementation(platform("androidx.compose:compose-bom:2024.02.00"))

        // Jetpack Compose
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")
        implementation("androidx.compose.foundation:foundation")

        // Navigation Compose (Навигация)
        implementation("androidx.navigation:navigation-compose:2.7.5")

        // Coil для загрузки изображений
        implementation ("io.coil-kt:coil-compose:2.0.0")


        // ViewModel + Lifecycle для Compose
        implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
            implementation("androidx.compose.material:material-icons-extended:1.5.4")


        // Koin (DI) для ViewModel и других зависимостей
        implementation("io.insert-koin:koin-androidx-compose:3.5.3")

        // Тестирование и инструменты отладки
        androidTestImplementation("androidx.compose.ui:ui-test-junit4")
        debugImplementation("androidx.compose.ui:ui-tooling")
    }

}