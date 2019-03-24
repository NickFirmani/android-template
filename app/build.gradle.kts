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
  buildTypes {
    getByName("debug") {
      applicationIdSuffix = ".debug"
      versionNameSuffix = "-dev"
    }
    getByName("release") {

      postprocessing.apply {
        proguardFiles("proguard-rules.pro")
        isOptimizeCode = true
        isObfuscate = true
        isRemoveUnusedCode = true
        isRemoveUnusedResources = true
      }
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

  // Test
  testImplementation(deps.test.junit)
}
