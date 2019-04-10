package com.nickfirmani.template

import android.app.Application
import com.facebook.buck.android.support.exopackage.DefaultApplicationLike

class TemplateApp(val appContext: Application) : DefaultApplicationLike() {
  companion object {
    lateinit var component: AppComponent
      private set
  }

  override fun onCreate() {
    super.onCreate()
    component = DaggerAppComponent.builder()
      .application(appContext)
      .build()
  }
}
