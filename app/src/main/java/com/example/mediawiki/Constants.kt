package com.example.mediawiki

import com.example.mediawiki.Constants.API_URL
import com.example.mediawiki.datasource.RemoteDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {

    const val API_URL = "https://en.wikipedia.org/w/"
    const val PAGE_URL = "api.php?action=query&format=json&prop=pageimages%7Cpageterms&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail&pithumbsize=50&pilimit=10&wbptterms=description&gpssearch=Sachin+T&gpslimit=30"
}