import org.gradle.api.tasks.testing.TestListener
import org.gradle.api.tasks.testing.TestDescriptor
import org.gradle.api.tasks.testing.TestResult

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

tasks.withType<Test>().configureEach {
    if (name.startsWith("test")) {
        addTestListener(object : TestListener {
            override fun beforeSuite(desc: TestDescriptor) {}
            override fun afterSuite(desc: TestDescriptor, result: TestResult) {}

            override fun beforeTest(desc: TestDescriptor) {}

            override fun afterTest(desc: TestDescriptor, result: TestResult) {
                val statusColor = when (result.resultType) {
                    TestResult.ResultType.SUCCESS -> "\u001B[32m"
                    TestResult.ResultType.FAILURE -> "\u001B[31m"
                    TestResult.ResultType.SKIPPED -> "\u001B[33m"
                    else -> ""
                }
                val resetColor = "\u001B[0m"

                val durationMs = result.endTime - result.startTime

                val status = when (result.resultType) {
                    TestResult.ResultType.SUCCESS -> "PASSED "  // green
                    TestResult.ResultType.FAILURE -> "FAILED "  // red
                    TestResult.ResultType.SKIPPED -> "SKIPPED"  // yellow
                    else -> result.resultType.name
                }

                println("$statusColor[$status : ${durationMs}ms]$resetColor ${desc.className} > ${desc.name}")
            }
        })


        /*
        testLogging {
            events("passed", "skipped", "failed")
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }

        // Custom listener to print test results with duration on a separate line
        addTestListener(object : TestListener {
            override fun beforeSuite(desc: TestDescriptor) { }

            override fun afterSuite(desc: TestDescriptor, result: TestResult) { }

            override fun beforeTest(desc: TestDescriptor) { }

            override fun afterTest(desc: TestDescriptor, result: TestResult) { }
        })
        */
    }
}


android {
    namespace = "com.sonne.t2s"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.t2s"
        minSdk = 24
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
