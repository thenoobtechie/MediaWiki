package com.example.mediawiki.repo

import android.content.Context
import com.example.mediawiki.database.AppDatabase
import com.example.mediawiki.database.DataDao
import com.example.mediawiki.utils.Utility
import com.example.mediawiki.model.FeaturedResponseModel
import com.example.mediawiki.model.QueryModel
import com.example.mediawiki.utils.Utility.getFormattedInt
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import java.util.Calendar.*


class Repository(var dataDao: DataDao) {

    fun queryLive() = dataDao.getLiveData()

    fun fetchFeaturedList(context: Context) {

        GlobalScope.launch(Dispatchers.IO) {
            val service = Utility.getApiService()
            val calendar = getInstance()
            val year = getFormattedInt(calendar.get(YEAR))
            val month = getFormattedInt(calendar.get(MONTH))
            val day = getFormattedInt(calendar.get(DAY_OF_MONTH))
            val call = service.fetchData(year, month, day)
            val response = call?.execute()
            if (response?.isSuccessful == true) {
                val jsonResponse = response.body()
                val featuredResponse =
                    Gson().fromJson(jsonResponse, FeaturedResponseModel::class.java)
                featuredResponse?.let {
                    val data = it.mostRead.articles
                    if (!data.isNullOrEmpty()) AppDatabase.getInstance(context).getDataDao().insertAllData(
                        data
                    )
                }
            }
        }
    }
}