package com.example.mediawiki.model

import com.google.gson.annotations.SerializedName

data class Thumbnail(@SerializedName("source") var url: String, var width: Int, var height: Int)