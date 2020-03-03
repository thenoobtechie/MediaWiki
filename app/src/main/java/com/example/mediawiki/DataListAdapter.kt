package com.example.mediawiki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mediawiki.model.DataModel
import kotlinx.android.synthetic.main.list_item.view.*

class DataListAdapter(var list: List<DataModel>) :
    RecyclerView.Adapter<DataListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(dataModel: DataModel) {
            itemView.title_txt.text = dataModel.title
            dataModel.terms?.let { itemView.desc_txt.text = it.description[0] }
            dataModel.thumb?.let { Utility.loadImage(it.url, itemView.thumb) }
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
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun update(list: List<DataModel>) {
        this.list = list
        notifyDataSetChanged()
    }
}
