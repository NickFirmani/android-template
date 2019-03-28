buildscript {
  repositories {
    google()
    mavenCentral()
    jcenter()
  }
  dependencies {
    classpath(deps.android.gradlePlugin)
    classpath(deps.kotlin.gradlePlugin)
    classpath(deps.okbuck.okbuckPlugin)
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

apply(from = "apply_okbuck.gradle" )

