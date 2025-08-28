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

class GenderQuestionFragment : Fragment() {

    private lateinit var viewModel: FormViewModel

    companion object {
        fun newInstance() = GenderQuestionFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question_gender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(
            requireActivity(), FormViewModelFactory(FitnessRepository(requireContext()))
        )[FormViewModel::class.java]

        val btnNext = view.findViewById<Button>(R.id.btnProximo)
        val actGender = view.findViewById<MaterialAutoCompleteTextView>(R.id.actGenero)

        val genderItems = resources.getStringArray(R.array.genero_array)
        val genderAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, genderItems)
        actGender.setAdapter(genderAdapter)

        actGender.setOnClickListener { actGender.showDropDown() }
        actGender.setOnFocusChangeListener { _, hasFocus -> if (hasFocus) actGender.showDropDown() }

        btnNext.setOnClickListener {
            val gender = actGender.text?.toString()?.trim().orEmpty()
            viewModel.saveGender(gender)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ActivityLevelQuestionFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
}
