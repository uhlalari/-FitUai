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

class HeightQuestionFragment : Fragment() {

    private lateinit var viewModel: FormViewModel

    companion object {
        fun newInstance() = HeightQuestionFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question_height, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(
            requireActivity(), FormViewModelFactory(FitnessRepository(requireContext()))
        )[FormViewModel::class.java]

        val btnNext = view.findViewById<Button>(R.id.btnProximo)
        val etHeight = view.findViewById<EditText>(R.id.etAltura)

        btnNext.setOnClickListener {
            val height = etHeight.text.toString().toFloatOrNull()
            if (height != null) {
                viewModel.saveHeight(height)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, GenderQuestionFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(context, "Enter a valid height", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
