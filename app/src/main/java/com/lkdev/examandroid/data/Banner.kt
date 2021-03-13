package com.lkdev.examandroid.data

import androidx.recyclerview.widget.DiffUtil
import com.lkdev.examandroid.R

data class Banner(
    val id: Int,
    val image: Int
) {
    companion object {
        val LIST_MOCK = createMock()

        private fun createMock(): List<Banner> {
            val list = arrayListOf<Banner>()
            list.add(Banner(1, R.drawable.image1))
            list.add(Banner(2, R.drawable.image2))
            list.add(Banner(3, R.drawable.image3))
            list.add(Banner(4, R.drawable.image4))
            list.add(Banner(5, R.drawable.image5))
            list.add(Banner(6, R.drawable.image6))
            return list
        }

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Banner?>() {
            override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
                return oldItem.id == newItem.id
                        && oldItem.image == newItem.image
            }

            override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
                return oldItem == newItem
            }
        }
    }
}
