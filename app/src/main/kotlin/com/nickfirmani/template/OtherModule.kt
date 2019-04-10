package com.nickfirmani.template

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class OtherModule {

  @Module
  companion object {

    @Provides
    @JvmStatic
    @Singleton
    internal fun provideSomeObject(): SomeClass {
      // IRL you'd do some config here.
      return SomeClass()
    }
  }
}
