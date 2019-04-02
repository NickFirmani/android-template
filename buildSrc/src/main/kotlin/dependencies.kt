@file:Suppress("unused")

object deps {
  object versions {
    const val kotlin = "1.3.21"
    const val conductor = "3.0.0-rc1"
    const val mosby = "3.1.0"
    const val autodispose = "1.1.0"
    const val rxBinding = "3.0.0-alpha2"
  }

  object android {
    const val gradlePlugin = "com.android.tools.build:gradle:3.2.0"

    object androidx {
      const val appcompat = "androidx.appcompat:appcompat:1.0.2"
      const val corektx = "androidx.core:core-ktx:1.0.1"
      const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
      const val material = "com.google.android.material:material:1.0.0"
    }

    object build {
      const val buildToolsVersion = "28.0.3"
      const val compileSdkVersion = 28
      const val minSdkVersion = 21
      const val targetSdkVersion = 28
    }
  }

  object kotlin {
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}"
    object stdlib {
      const val core = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin}"
      const val jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${versions.kotlin}"
    }
  }

  object autoDispose {
    const val core = "com.uber.autodispose:autodispose:${versions.autodispose}"
    const val android = "com.uber.autodispose:autodispose-android:${versions.autodispose}"
    const val androidKtx = "com.uber.autodispose:autodispose-android-ktx:${versions.autodispose}"
    const val kotlin = "com.uber.autodispose:autodispose-ktx:${versions.autodispose}"
  }

  object conductor {
    const val core = "com.bluelinelabs:conductor:${versions.conductor}"
    const val autodispose = "com.bluelinelabs:conductor-autodispose:${versions.conductor}"
  }

  object mosby {
    const val conductor = "com.hannesdorfmann.mosby3:mvp-conductor:${versions.mosby}"
  }

  object rxBinding {
    const val core = "com.jakewharton.rxbinding3:rxbinding-core:${versions.rxBinding}"
  }

  object test {
    const val junit = "junit:junit:4.12"
  }

  object okbuck {
    const val okbuckPlugin = "com.uber:okbuck:0.47.0"
  }
}
