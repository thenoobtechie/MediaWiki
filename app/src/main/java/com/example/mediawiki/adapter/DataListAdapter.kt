package com.example.mediawiki.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediawiki.R
import com.example.mediawiki.model.DataModel
import com.example.mediawiki.utils.Utility
import com.example.mediawiki.model.QueryModel
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class DataListAdapter(var itemClickListener: ListItemClick) :
    RecyclerView.Adapter<DataListAdapter.ViewHolder>() {

    var list = listOf<DataModel>()
    var displayList = ArrayList<DataModel>()

    interface ListItemClick {

        fun onListItemClick(dataModel: DataModel)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(dataModel: DataModel) {
            itemView.title_txt.text = dataModel.displayTitle
            itemView.desc_txt.text = dataModel.description
            dataModel.thumb?.let {
                Utility.loadImage(
                    it.url,
                    itemView.thumb
                )
            }

            itemView.setOnClickListener {
                itemClickListener.onListItemClick(dataModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(displayList[position])
    }

    override fun getItemCount(): Int = displayList.size

    fun update(list: List<DataModel>) {
        this.list = list
        resetList()
    }

    fun filter(qry: String) {

        if (qry.isBlank())
            resetList()
        else {

            displayList.clear()
            this.list.forEach {
                if (it.title.toLowerCase(Locale.getDefault()).contains(qry.toLowerCase(Locale.getDefault()))) {
                    displayList.add(it)
                }
            }
            notifyDataSetChanged()
        }
    }

    private fun resetList() {
        this.list.forEach {
            displayList.add(it)
        }
        notifyDataSetChanged()
    }
}
