package com.example.mediawiki

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mediawiki.datasource.RemoteDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utility {
    fun getApiService(): RemoteDataSource.ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RemoteDataSource.ApiService::class.java)
    }

    fun loadImage(url: String, thumb: ImageView) {
        Glide.with(thumb).load(url).centerCrop().into(thumb)
    }
}