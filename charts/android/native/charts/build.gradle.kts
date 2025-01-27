plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.charts"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
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

// Create configuration for copyDependencies
configurations {
    create("copyDependencies")
}

dependencies {
    // Add dependencies
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
//    implementation("org.kodein.di:kodein-di:7.21.1")
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("com.github.Truvideo:truvideo-sdk-android-core:76.2.5")
    implementation("io.ktor:ktor-client-android:2.3.10")
    implementation("io.ktor:ktor-client-android:2.3.10")
    // Add dependencies to the copyDependencies configuration
    configurations["copyDependencies"].dependencies.add(
        project.dependencies.create("org.kodein.di:kodein-di:7.21.1")
    )
    configurations["copyDependencies"].dependencies.add(
        project.dependencies.create("com.github.PhilJay:MPAndroidChart:v3.1.0")
    )
    configurations["copyDependencies"].dependencies.add(
        project.dependencies.create("com.github.Truvideo:truvideo-sdk-android-core:76.2.5")
    )
}

// Copy dependencies for binding library
project.afterEvaluate {
    tasks.register<Copy>("copyDeps") {
        // Copy both .aar and .jar files
        from(configurations["copyDependencies"].filter {
            it.name.endsWith(".aar") || it.name.endsWith(".jar")
        })
        into("${buildDir}/outputs/deps")
    }
    tasks.named("preBuild") { finalizedBy("copyDeps") }
}