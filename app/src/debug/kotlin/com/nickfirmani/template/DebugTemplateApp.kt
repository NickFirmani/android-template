package com.nickfirmani.template

import android.app.Application

class DebugTemplateApp(appContext: Application): TemplateApp(appContext = appContext) {
  companion object {
    lateinit var component: AppComponent
      private set
  }

  override fun onCreate() {
    super.onCreate()
    component = DaggerDebugAppComponent.builder()
      .application(appContext)
      .build()

  }
}
