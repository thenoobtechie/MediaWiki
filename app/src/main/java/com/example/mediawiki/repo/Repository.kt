package com.example.mediawiki.repo

import com.example.mediawiki.utils.Utility
import com.example.mediawiki.model.FeaturedResponseModel
import com.example.mediawiki.model.QueryModel
import com.example.mediawiki.utils.Utility.getFormattedInt
import com.google.gson.Gson
import java.util.*
import java.util.Calendar.*


class Repository {

    fun fetchData(isOnline: Boolean = true): FeaturedResponseModel? {

        if (isOnline) {

            val service = Utility.getApiService()

            val calendar = getInstance()
            val year = getFormattedInt(calendar.get(YEAR))
            val month = getFormattedInt(calendar.get(MONTH))
            val day = getFormattedInt(calendar.get(DAY_OF_MONTH))
            val call = service.fetchData(year, month, day)
            val response = call?.execute()
            if (response?.isSuccessful == true) {
                val jsonResponse = response.body()
                return Gson().fromJson(jsonResponse, FeaturedResponseModel::class.java)
            }
            else
            {
                //TODO Error handling
            }
        } else {
            //TODO FetchFromDB
        }

        return null
    }
}