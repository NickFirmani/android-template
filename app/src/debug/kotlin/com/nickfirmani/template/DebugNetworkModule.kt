package com.nickfirmani.template

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.nickfirmani.template.annotations.AppContext
import com.nickfirmani.template.annotations.NetworkInterceptor
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Singleton

@Module
object DebugNetworkModule {

  @Provides
  @NetworkInterceptor
  @IntoSet
  @JvmStatic
  @Singleton
  fun provideLoggingInterceptor(): Interceptor {
    val loggingInterceptor = HttpLoggingInterceptor { message ->
      Timber.tag("OkHttp")
        .v(message)
    }
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return loggingInterceptor
  }

  @Provides
  @NetworkInterceptor
  @IntoSet
  @JvmStatic
  @Singleton
  fun provideStethoInterceptor(): Interceptor = StethoInterceptor()

  @Provides
  @NetworkInterceptor
  @IntoSet
  @JvmStatic
  @Singleton
  fun provideChuckInterceptor(@AppContext context: Context): Interceptor = ChuckInterceptor(context)

}
