/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mediawiki.utils

import androidx.room.TypeConverter
import com.example.mediawiki.model.ContentUrls
import com.example.mediawiki.model.MobileUrls
import com.example.mediawiki.model.Thumbnail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


/**
 * Type converters to allow Room to reference complex data types.
 */
class Converters {

    @TypeConverter fun stringToContentUrlsObj(string: String?): ContentUrls? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<ContentUrls?>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter fun contentUrlsToString(contentUrls: ContentUrls?): String = Gson().toJson(contentUrls)

    @TypeConverter fun stringToMobileUrlsObj(string: String?): MobileUrls? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<MobileUrls?>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter fun mobileUrlsToString(mobileUrls: MobileUrls?): String = Gson().toJson(mobileUrls)

    @TypeConverter fun stringToThumbnailObj(string: String?): Thumbnail? {
        if (string == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<Thumbnail?>() {}.type
        return gson.fromJson(string, type)
    }

    @TypeConverter fun thumbnailToString(thumbnail: Thumbnail?): String = Gson().toJson(thumbnail)
}