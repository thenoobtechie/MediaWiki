package com.example.mediawiki.model

import com.google.gson.annotations.SerializedName

data class MobileUrls(var page: String, var revisions: String, var edit: String, var talk: String)
data class ContentUrls(var mobile: MobileUrls)

data class Thumbnail(@SerializedName("source") var url: String, var width: Int, var height: Int)

data class DataModel(
    var pageid: String,
    var title: String,
    var description: String,
    @SerializedName("displaytitle") var displayTitle: String,
    @SerializedName("thumbnail") var thumb: Thumbnail,
    @SerializedName("content_urls") var contentUrls: ContentUrls
)