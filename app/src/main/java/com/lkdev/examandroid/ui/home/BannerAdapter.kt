package com.lkdev.examandroid.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lkdev.examandroid.R
import com.lkdev.examandroid.data.Banner
import kotlinx.android.synthetic.main.item_banner.view.*

class BannerAdapter : ListAdapter<Banner, BannerViewHolder>(Banner.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Banner) {
        itemView.bannerImage.setImageResource(item.image)
    }
}