package com.example.mediawiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediawiki.model.MostReadResponseModel
import com.example.mediawiki.model.QueryModel
import com.example.mediawiki.repo.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ViewModel: ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.IO

    val mostReadArticles: MutableLiveData<MostReadResponseModel> by lazy {
        MutableLiveData<MostReadResponseModel>().also {
            fetchData()
        }
    }

    private fun fetchData(/*isOnline: Boolean, callback: Callback<ResponseModel>*/) {

        viewModelScope.launch(Dispatchers.IO) {
            val response = Repository().fetchData()
            if (response != null) {
                mostReadArticles.postValue(response.mostRead)
            }
        }
    }
}