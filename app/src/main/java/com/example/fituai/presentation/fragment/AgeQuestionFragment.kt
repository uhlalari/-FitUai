package com.example.fituai.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fituai.R
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.presentation.viewmodel.FormViewModel
import com.example.fituai.presentation.viewmodel.FormViewModelFactory

class AgeQuestionFragment : Fragment() {

    private lateinit var viewModel: FormViewModel

    companion object {
        fun newInstance() = AgeQuestionFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question_age, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(
            requireActivity(), FormViewModelFactory(FitnessRepository(requireContext()))
        ).get(FormViewModel::class.java)

        val btnNext = view.findViewById<Button>(R.id.btnProximo)
        val etAge = view.findViewById<EditText>(R.id.etIdade)

        btnNext.setOnClickListener {
            val age = etAge.text.toString().toIntOrNull()
            if (age != null) {
                viewModel.saveAge(age)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, WeightQuestionFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(context, "Enter a valid age", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
