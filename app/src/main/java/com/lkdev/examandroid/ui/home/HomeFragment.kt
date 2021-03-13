package com.lkdev.examandroid.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.scale
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lkdev.examandroid.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.NumberFormat

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<View>(R.id.text_home).setOnClickListener {
//            App.mSocket?.emit("new-notification")
//        }

        val goalAdapter = GoalAdapter()
        view.goalRecyclerView.apply {
            adapter = goalAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        homeViewModel.goalLiveData.observe(viewLifecycleOwner, {
            goalAdapter.submitList(it)
            view.goalCountText.text = "${it.size} Goals"
            view.savingText.text = buildSpannedString {
                append("All Saving ")
                bold {
                    scale(2F) {
                        append(NumberFormat.getInstance().format(it.sumBy { goal -> goal.currentGoal }))
                    }
                }
                append(" THB")
            }
        })

        val baseOfferAdapter = BannerAdapter()
        val suggestAdapter = BannerAdapter()
        view.baseOfferRecyclerView.apply {
            adapter = baseOfferAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        view.suggestRecyclerView.apply {
            adapter = suggestAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        homeViewModel.bannerLiveData.observe(viewLifecycleOwner, {
            baseOfferAdapter.submitList(it)
            suggestAdapter.submitList(it.shuffled())
        })
    }
}