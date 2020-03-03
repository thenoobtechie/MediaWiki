package com.example.mediawiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediawiki.model.DataModel
import com.example.mediawiki.model.ResponseModel
import com.example.mediawiki.repo.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Callback
import kotlin.coroutines.CoroutineContext

class ViewModel: ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.IO

    val data: MutableLiveData<List<DataModel>> by lazy {
        MutableLiveData<List<DataModel>>().also {
            fetchData()
        }
    }

    private fun fetchData(/*isOnline: Boolean, callback: Callback<ResponseModel>*/) {

        viewModelScope.launch(Dispatchers.IO) {
            val response = Repository().fetchData()
            if (response != null) {
                data.postValue(response)
            }
        }
    }
}