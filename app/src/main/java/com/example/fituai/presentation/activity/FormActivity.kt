package com.example.fituai.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fituai.R
import com.example.fituai.presentation.fragment.AgeQuestionFragment


class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AgeQuestionFragment.newInstance())
                .commit()
        }
    }
}
