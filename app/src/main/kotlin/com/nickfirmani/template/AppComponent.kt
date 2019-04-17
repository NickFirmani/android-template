package com.nickfirmani.template

import android.app.Application
import com.nickfirmani.template.annotations.AppContext
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AppModule::class,
    NetworkModule::class
  ]
)
interface AppComponent {
  @Component.Builder
  interface Builder {

    @AppContext
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent
  }

  fun mainComponent(): MainComponent.Builder
}
