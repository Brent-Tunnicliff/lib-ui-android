// Copyright © 2024 Brent Tunnicliff <brent@tunnicliff.dev>

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.serialization)
    id("maven-publish")
}

android {
    namespace = "dev.tunnicliff.ui"
    compileSdk = 35

    defaultConfig {
        minSdk = 33

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = "dev.tunnicliff"
                artifactId = "lib-ui-android"
                version = "0.1.0-alpha.8"

                pom {
                    packaging = "aar"
                    name.set("lib-ui-android")
                    description.set("lib-ui-android: Common UI components for my apps.")
                    url.set("https://github.com/Brent-Tunnicliff/lib-ui-android")
                    inceptionYear.set("2024")

                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }

                    developers {
                        developer {
                            id.set("brent")
                            name.set("Brent Tunnicliff")
                            email.set("brent@tunnicliff.dev")
                        }
                    }

                    scm {
                        connection.set("scm:git:https://github.com/Brent-Tunnicliff/lib-ui-android.git")
                        developerConnection.set("scm:git:ssh://git@github.com:Brent-Tunnicliff/lib-ui-android.git")
                        url.set("https://github.com/Brent-Tunnicliff/lib-ui-android")
                    }
                }
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.paging.compose.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.material)

    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    testImplementation(libs.junit)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}