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

class WeightQuestionFragment : Fragment() {

    private lateinit var viewModel: FormViewModel

    companion object {
        fun newInstance() = WeightQuestionFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_question_weight, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(
            requireActivity(), FormViewModelFactory(FitnessRepository(requireContext()))
        )[FormViewModel::class.java]

        val btnNext = view.findViewById<Button>(R.id.btnProximo)
        val etWeight = view.findViewById<EditText>(R.id.etPeso)

        btnNext.setOnClickListener {
            val weight = etWeight.text.toString().toFloatOrNull()
            if (weight != null) {
                viewModel.saveWeight(weight)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, HeightQuestionFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(context, "Informe um peso válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
