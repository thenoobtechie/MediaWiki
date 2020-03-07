package com.example.mediawiki.view

import android.os.Bundle
import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.mediawiki.R
import com.example.mediawiki.adapter.DataListAdapter
import com.example.mediawiki.model.DataModel
import com.example.mediawiki.utils.Utility
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.progress_layout.*

class HomeActivity : AppCompatActivity(), DataListAdapter.ListItemClick {

    lateinit var listAdapter: DataListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        progress_layout.visibility = VISIBLE
        val viewModel = Utility.getViewModel(this)

        feeds_list.addItemDecoration(DividerItemDecoration(this, VERTICAL))
        listAdapter = DataListAdapter(this)
        feeds_list.adapter = listAdapter

        search_view.setOnQueryTextListener(object: OnQueryTextListener {

            val handler = Handler()
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchQry(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchQry(newText)
                return true
            }

            fun searchQry(qry: String?) {

                handler.removeCallbacksAndMessages(null)
                handler.postDelayed({
                    qry?.let { listAdapter.filter(it) }
                }, 300)
            }

        })

        viewModel.mostReadArticles.observe(this,
            Observer {
                if (!it.isNullOrEmpty()) {
                    progress_layout.visibility = GONE
                    listAdapter.update(it)
                }
            })
    }

    override fun onListItemClick(dataModel: DataModel) {
        Utility.openUrlInBrowser(this, dataModel.contentUrls.mobile.page)
    }
}
