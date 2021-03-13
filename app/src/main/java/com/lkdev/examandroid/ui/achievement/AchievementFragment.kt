package com.lkdev.examandroid.ui.achievement

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.lkdev.examandroid.R
import kotlinx.android.synthetic.main.fragment_achievement.view.*

class AchievementFragment : Fragment() {

    private lateinit var achievementViewModel: AchievementViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        achievementViewModel = ViewModelProvider(this).get(AchievementViewModel::class.java)
        return inflater.inflate(R.layout.fragment_achievement, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val achievementAdapter = AchievementAdapter()
        view.achievementRecyclerView.apply {
            adapter = achievementAdapter
            layoutManager = GridLayoutManager(context, 3)
        }

        achievementViewModel.achievementInfoLiveData.observe(viewLifecycleOwner, {
            view.achievementImage.setImageResource(it.icon)
            view.levelText.text = "Level ${it.level}"
            achievementAdapter.submitList(it.achievements)
        })
    }
}