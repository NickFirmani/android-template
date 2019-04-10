plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
}

apply {
  from(rootProject.file("gradle/config-kotlin-sources.gradle"))
}

android {
  compileSdkVersion(deps.android.build.compileSdkVersion)
  buildToolsVersion(deps.android.build.buildToolsVersion)

  defaultConfig {
    applicationId = "com.nickfirmani.template"
    minSdkVersion(deps.android.build.minSdkVersion)
    targetSdkVersion(deps.android.build.targetSdkVersion)
    versionCode = 1
    versionName = "1.0"
    vectorDrawables.useSupportLibrary = true
  }

  signingConfigs {
    create("release") {
      // TODO release key
      storeFile = rootProject.file("app/debug.keystore")
      storePassword = properties["UPLOAD_STORE_PASSWORD"] as String? ?: ""
      keyPassword = properties["UPLOAD_KEY_PASSWORD"] as String? ?: ""
      keyAlias = properties["UPLOAD_KEY_ALIAS"] as String? ?: ""
      isV2SigningEnabled = true
    }
    getByName("debug") {
      storeFile = rootProject.file("app/debug.keystore")
    }
  }

  buildTypes {
    getByName("debug") {
      signingConfig = signingConfigs.findByName("debug")
      applicationIdSuffix = ".debug"
      versionNameSuffix = "-dev"
    }
    getByName("release") {
      signingConfig = signingConfigs.findByName("release")
      proguardFiles("proguard-rules.pro")
      isMinifyEnabled = true
      isShrinkResources = true
      setCrunchPngs(true)
    }
  }
}

kapt {
  useBuildCache = true
}

dependencies {

  implementation(deps.kotlin.stdlib.jdk7)

  // AndroidX
  implementation(deps.android.androidx.appcompat)
  implementation(deps.android.androidx.corektx)
  implementation(deps.android.androidx.constraintLayout)


  implementation(deps.dagger.core)
  kapt(deps.kapt.dagger)

  // Test
  testImplementation(deps.test.junit)
}
