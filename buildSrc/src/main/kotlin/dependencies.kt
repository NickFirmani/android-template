@file:Suppress("unused")

object deps {
  object versions {
    const val kotlin = "1.3.20"
    const val conductor = "3.0.0-rc1"
    const val mosby = "3.1.0"
    const val autodispose = "1.1.0"
    const val rxBinding = "3.0.0-alpha2"
    const val dagger = "2.22"
    const val moshi = "1.8.0"
    const val retrofit = "2.5.0"
    const val okhttp = "3.14.0"
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
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${versions.kotlin}"
    object stdlib {
      const val core = "org.jetbrains.kotlin:kotlin-stdlib:${versions.kotlin}"
      const val jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${versions.kotlin}"
    }
  }

  object dagger {
    const val core = "com.google.dagger:dagger:${versions.dagger}"
  }

  object io {
    object retrofit {
      const val core = "com.squareup.retrofit2:retrofit:${versions.retrofit}"
      const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${versions.retrofit}"
      const val rx2Adapter ="com.squareup.retrofit2:adapter-rxjava2:${versions.retrofit}"
    }

    object okhttp {
      const val core = "com.squareup.okhttp3:okhttp:${versions.okhttp}"
    }

    const val moshi = "com.squareup.moshi:moshi-kotlin:${versions.moshi}"
  }

  object kapt {
    const val autoFactory = "com.google.auto.factory:auto-factory:1.0-beta6"
    const val dagger = "com.google.dagger:dagger-compiler:${versions.dagger}"
    const val moshi = "com.squareup.moshi:moshi-kotlin-codegen:${versions.moshi}"
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
