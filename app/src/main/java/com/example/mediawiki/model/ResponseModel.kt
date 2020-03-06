package com.example.mediawiki.model

import com.google.gson.annotations.SerializedName

data class MostReadResponseModel(var articles: List<DataModel>, var date: String)
data class NewsResponseModel(var links: List<DataModel>, var story: String)

data class QueryModel(var pages: List<DataModel>)

//data class ResponseModel(var query: QueryModel, var batchComplete: Boolean)
data class FeaturedResponseModel(@SerializedName("news") var news: List<NewsResponseModel>,
                                 @SerializedName("onthisday") var onThisDay: List<QueryModel>,
                                 @SerializedName("mostread") var mostRead: MostReadResponseModel)