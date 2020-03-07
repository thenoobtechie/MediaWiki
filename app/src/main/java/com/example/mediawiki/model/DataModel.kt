package com.example.mediawiki.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MobileUrls(var page: String, var revisions: String, var edit: String, var talk: String)
data class ContentUrls(var mobile: MobileUrls)

data class Thumbnail(@SerializedName("source") var url: String, var width: Int, var height: Int)

@Entity(tableName = "data_table")
data class DataModel(
    @PrimaryKey @ColumnInfo(name = "id") var pageid: String,
    var title: String,
    var description: String? = null,
    @SerializedName("displaytitle") @ColumnInfo(name = "display_title") var displayTitle: String,
    @SerializedName("thumbnail") var thumb: Thumbnail? = null,
    @SerializedName("content_urls") @ColumnInfo(name = "content_urls") var contentUrls: ContentUrls
)