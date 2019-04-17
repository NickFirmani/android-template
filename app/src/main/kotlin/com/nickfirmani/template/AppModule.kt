package com.nickfirmani.template

import android.app.Application
import android.content.Context
import com.nickfirmani.template.annotations.AppContext
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(subcomponents = [MainComponent::class])
abstract class AppModule {

  @Binds
  @AppContext
  @Singleton
  abstract fun provideApplicationContext(application: Application): Context
}
