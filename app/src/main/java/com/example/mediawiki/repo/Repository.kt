package com.example.mediawiki.repo

import com.example.mediawiki.Constants
import com.example.mediawiki.Utility
import com.example.mediawiki.datasource.RemoteDataSource
import com.example.mediawiki.model.DataModel
import com.example.mediawiki.model.ResponseModel
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Retrofit
import kotlin.coroutines.CoroutineContext


class Repository {

    fun fetchData(isOnline: Boolean = true): List<DataModel>? {

        var data: List<DataModel>? = null
        if (isOnline) {

            val service = Utility.getApiService()
            val call = service.fetchData()
            val responseModel = Gson().fromJson(call?.execute()?.body(), ResponseModel::class.java)
            data = responseModel.query.pages
        } else {
            //TODO (not implemented)FetchFromDB
        }

        return data
    }
}