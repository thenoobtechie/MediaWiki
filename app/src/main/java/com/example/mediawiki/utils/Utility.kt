package com.example.mediawiki.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.example.mediawiki.database.AppDatabase
import com.example.mediawiki.datasource.RemoteDataSource
import com.example.mediawiki.repo.Repository
import com.example.mediawiki.viewmodel.ViewModel
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

    fun getViewModel(context: Context): ViewModel {
        return ViewModel(getRepository(context))
    }

    fun getRepository(context: Context): Repository {
        return Repository(AppDatabase.getInstance(context).getDataDao())
    }

    fun loadImage(url: String, thumb: ImageView) {
        Glide.with(thumb).load(url).centerCrop().into(thumb)
    }

    fun openUrlInBrowser(context: Context, url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(browserIntent)
    }

    fun getFormattedInt(value: Int) = String.format("%02d", value)
}