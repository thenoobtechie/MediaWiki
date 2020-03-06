package com.example.mediawiki.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mediawiki.R
import com.example.mediawiki.adapter.DataListAdapter
import com.example.mediawiki.model.DataModel
import com.example.mediawiki.model.MostReadResponseModel
import com.example.mediawiki.model.QueryModel
import com.example.mediawiki.utils.Utility
import com.example.mediawiki.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.progress_layout.*

class HomeActivity : AppCompatActivity(), DataListAdapter.ListItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        progress_layout.visibility = VISIBLE
        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        feeds_list.adapter =
            DataListAdapter(arrayListOf(), this)

        viewModel.mostReadArticles.observe(this,
            Observer<MostReadResponseModel> {
                if (it != null) {
                    progress_layout.visibility = GONE
                    (feeds_list.adapter as DataListAdapter).apply {
                        update(it.articles)
                    }
                }
            })
    }

    override fun onListItemClick(dataModel: DataModel) {
        Utility.openUrlInBrowser(this, dataModel.contentUrls.mobile.page)
    }
}
