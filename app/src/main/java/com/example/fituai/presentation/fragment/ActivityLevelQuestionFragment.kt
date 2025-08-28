package com.example.fituai.presentation.fragment

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
import com.example.fituai.presentation.viewmodel.FormViewModel
import com.example.fituai.presentation.viewmodel.FormViewModelFactory

class ActivityLevelQuestionFragment : Fragment() {

    private lateinit var viewModel: FormViewModel

    companion object {
        fun newInstance() = ActivityLevelQuestionFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question_activity_level, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(
            requireActivity(), FormViewModelFactory(FitnessRepository(requireContext()))
        )[FormViewModel::class.java]

        val btnNext = view.findViewById<Button>(R.id.btnProximo)
        val actLevel = view.findViewById<MaterialAutoCompleteTextView>(R.id.actNivelAtividade)

        val levelItems = resources.getStringArray(R.array.nivel_atividade_array)
        val levelAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, levelItems)
        actLevel.setAdapter(levelAdapter)

        actLevel.setOnClickListener { actLevel.showDropDown() }
        actLevel.setOnFocusChangeListener { _, hasFocus -> if (hasFocus) actLevel.showDropDown() }

        btnNext.setOnClickListener {
            val level = actLevel.text?.toString()?.trim().orEmpty()
            viewModel.saveActivityLevel(level)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, GoalQuestionFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
}
