package com.nickfirmani.template

import android.content.Context
import android.os.Looper
import com.nickfirmani.template.annotations.AppContext
import com.nickfirmani.template.annotations.NetworkInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.multibindings.Multibinds
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
abstract class NetworkModule {

  @NetworkInterceptor
  @Multibinds
  abstract fun provideNetworkInterceptors(): Set<Interceptor>

  @Multibinds
  abstract fun provideInterceptors(): Set<Interceptor>

  @Module
  companion object {

    private const val HTTP_RESPONSE_CACHE_BYTES = (10 * 1024 * 1024).toLong()
    private const val HTTP_TIMEOUT_SECONDS = 30

    @Provides
    @JvmStatic
    @Singleton
    fun provideCache(@AppContext context: Context): Cache {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        throw IllegalStateException("Cache initialized on main thread.")
      }
      return Cache(context.cacheDir, HTTP_RESPONSE_CACHE_BYTES)
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideOkHttpClient(
      cache: Cache,
      interceptors: Set<@JvmSuppressWildcards Interceptor>,
      @NetworkInterceptor networkInterceptors: Set<@JvmSuppressWildcards Interceptor>
    ): OkHttpClient {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        throw IllegalStateException("HTTP client initialized on main thread.")
      }

      val builder = OkHttpClient.Builder().connectTimeout(HTTP_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .readTimeout(HTTP_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .writeTimeout(HTTP_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .cache(cache)

      builder.networkInterceptors().addAll(networkInterceptors)
      builder.interceptors().addAll(interceptors)

      return builder.build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideMoshi(): Moshi {
      return Moshi.Builder().build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
      return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }
  }
}

