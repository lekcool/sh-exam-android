package com.lkdev.examandroid.ui.goal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.lkdev.examandroid.R
import kotlinx.android.synthetic.main.fragment_goal_add.view.*

class AddGoalFragment : Fragment() {

    private lateinit var viewModel: GoalViewModel

    private val datePicker = MaterialDatePicker.Builder.datePicker().build()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(GoalViewModel::class.java)
        return inflater.inflate(R.layout.fragment_goal_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goalTypeAdapter = GoalTypeAdapter()
        view.goalTypeRecyclerView.apply {
            adapter = goalTypeAdapter
            layoutManager = GridLayoutManager(context, 3)
        }

        viewModel.typeLiveData.observe(viewLifecycleOwner, {
            goalTypeAdapter.submitList(it)
        })

        datePicker.addOnPositiveButtonClickListener {
            view.selectDateInput.text = datePicker.headerText
        }
        view.selectDateInput.setOnClickListener {
            datePicker.show(childFragmentManager, "date_picker_dialog")
        }
    }
}