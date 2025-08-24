package com.example.fituai.presentation.ui

import android.content.Context
import android.graphics.Color.BLUE
import android.graphics.Color.GRAY
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.fituai.R

class StepProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var currentStep = 1
    private var totalSteps = 5

    init {
        orientation = HORIZONTAL
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.StepProgressView)
            currentStep = typedArray.getInt(R.styleable.StepProgressView_currentStep, 1)
            totalSteps = typedArray.getInt(R.styleable.StepProgressView_totalSteps, 5)
            typedArray.recycle()
        }
        updateSteps()
    }

    private fun updateSteps() {
        removeAllViews()
        for (i in 1..totalSteps) {
            val view = View(context)
            view.setBackgroundColor(if (i <= currentStep) BLUE else GRAY)
            val params = LayoutParams(0, 8, 1f)
            params.marginEnd = 8
            view.layoutParams = params
            addView(view)
        }
    }
}
