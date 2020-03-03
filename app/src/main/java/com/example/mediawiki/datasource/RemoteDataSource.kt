package com.example.mediawiki.datasource

import com.example.mediawiki.Constants
import com.example.mediawiki.model.DataModel
import com.example.mediawiki.model.ResponseModel
import com.google.gson.JsonElement
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


class RemoteDataSource {

    interface ApiService {
        @GET(Constants.PAGE_URL)
        fun fetchData(): Call<JsonElement?>?
    }
}