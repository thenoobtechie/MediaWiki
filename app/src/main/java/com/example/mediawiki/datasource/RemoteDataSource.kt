package com.example.mediawiki.datasource

import androidx.annotation.NonNull
import com.example.mediawiki.utils.Constants
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


class RemoteDataSource {

    interface ApiService {
        @GET("api/rest_v1/feed/featured/{year}/{month}/{day}")
        @NonNull fun fetchData(@Path("year") year: String,
                      @Path("month") month: String,
                      @Path("day") day: String): Call<JsonElement?>?
    }
}