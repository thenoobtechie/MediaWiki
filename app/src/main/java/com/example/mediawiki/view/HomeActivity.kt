package com.example.mediawiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mediawiki.model.DataModel
import com.example.mediawiki.model.ResponseModel
import com.example.mediawiki.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.progress_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        progress_layout.visibility = VISIBLE
        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        feeds_list.adapter = DataListAdapter(arrayListOf())

        viewModel.data.observe(this,
            Observer<List<DataModel>> {
                if (!it.isNullOrEmpty()) {
                    progress_layout.visibility = GONE
                    (feeds_list.adapter as DataListAdapter).apply {
                        update(it)
                    }
                }
            })
    }
}
