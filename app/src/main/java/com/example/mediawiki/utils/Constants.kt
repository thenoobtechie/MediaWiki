package com.example.mediawiki.utils

object Constants {

    const val API_URL = "https://en.wikipedia.org/"
    const val SEARCH_PAGE_URL = "api.php?action=query&format=json&prop=pageimages%7Cpageterms&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail&pithumbsize=50&pilimit=10&wbptterms=description&gpssearch=Sachin+T&gpslimit=30"
    const val FEATURED_FEEDS_PAGE_URL = "api/rest_v1/feed/featured/2020/03/05"
}