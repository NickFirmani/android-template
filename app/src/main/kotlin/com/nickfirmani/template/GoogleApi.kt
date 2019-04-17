package com.nickfirmani.template

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface GoogleApi {
  @GET("generate_204")
  fun generate204(): Single<Response<Unit>>
}
