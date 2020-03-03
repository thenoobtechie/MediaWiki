package com.example.mediawiki.model

import com.google.gson.annotations.SerializedName

data class DataModel(
    var pageid: String,
    var title: String, @SerializedName("thumbnail") var thumb: Thumbnail,
    var terms: TermsModel
)