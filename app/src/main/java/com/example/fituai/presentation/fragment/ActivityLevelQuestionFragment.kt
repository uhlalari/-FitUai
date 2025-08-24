package com.example.fituai.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
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
        val spLevel = view.findViewById<Spinner>(R.id.spNivelAtividade)

        btnNext.setOnClickListener {
            val level = spLevel.selectedItem.toString()
            viewModel.saveActivityLevel(level)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, GoalQuestionFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
}
