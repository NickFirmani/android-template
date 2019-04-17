package com.nickfirmani.template

import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
abstract class GoogleApiModule {

  @Module
  companion object {

    @Provides
    @JvmStatic
    @Reusable
    fun provideGoogleApi(client: dagger.Lazy<OkHttpClient>): GoogleApi {
      return Retrofit.Builder()
        .callFactory { client.get().newCall(it) }
        .baseUrl("https://clients3.google.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GoogleApi::class.java)
    }
  }
}
