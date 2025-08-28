package com.example.fituai.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ArrayAdapter
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fituai.R
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.presentation.activity.ResultsActivity
import com.example.fituai.presentation.viewmodel.FormViewModel
import com.example.fituai.presentation.viewmodel.FormViewModelFactory

class GoalQuestionFragment : Fragment() {

    private lateinit var viewModel: FormViewModel

    companion object {
        fun newInstance() = GoalQuestionFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question_goal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(
            requireActivity(), FormViewModelFactory(FitnessRepository(requireContext()))
        )[FormViewModel::class.java]

        val btnFinish = view.findViewById<Button>(R.id.btnFinalizar)
        val actGoal = view.findViewById<MaterialAutoCompleteTextView>(R.id.actObjetivo)

        val goalItems = resources.getStringArray(R.array.objetivo_array)
        val goalAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, goalItems)
        actGoal.setAdapter(goalAdapter)

        actGoal.setOnClickListener { actGoal.showDropDown() }
        actGoal.setOnFocusChangeListener { _, hasFocus -> if (hasFocus) actGoal.showDropDown() }

        btnFinish.setOnClickListener {
            val goal = actGoal.text?.toString()?.trim().orEmpty()
            viewModel.saveGoal(goal)

            startActivity(Intent(requireContext(), ResultsActivity::class.java))
            requireActivity().finish()
        }
    }
}
