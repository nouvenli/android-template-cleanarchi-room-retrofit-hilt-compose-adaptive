plugins {
    alias(libs.plugins.android.application)
    //alias(libs.plugins.kotlin.android)  plus nécessaire avec AGP 9
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "fr.quinquenaire.templatebddreseauadaptive"

    compileSdk = 36

    defaultConfig {
        applicationId = "fr.quinquenaire.templatebddreseauadaptive"
        minSdk = 26
        targetSdk = 36
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

    buildFeatures {
        compose = true
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
// ── Core Android ──
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

// ── Tests ──
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit4)

// ── Compose (via BOM : toutes les libs Compose partagent la même version) ──
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
    implementation("androidx.compose.material:material-icons-extended")
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

// ── Window Size Class (layout adaptatif téléphone / tablette) ──
    implementation(libs.material3.window.size)

    // ── Lifecycle & ViewModel ──
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.runtime.compose)       // collectAsStateWithLifecycle()
    implementation(libs.lifecycle.viewmodel.compose)     // viewModel() dans Compose

    // ── Room (base de données locale) ──
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

// ── Networking (Retrofit & Json/Kotlin)
    implementation(libs.retrofit)
    implementation(libs.converter.kotlinx)
    implementation(libs.okhttp)

// Serialization
    implementation(libs.kotlinx.serialization.json)

// ── Coroutines ──
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

// ── Hilt (injection de dépendances) ──
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)         // hiltViewModel()

// ── Coil (chargement d'images) ──
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)               // utilise OKHTTP comme moteur réseau

}
