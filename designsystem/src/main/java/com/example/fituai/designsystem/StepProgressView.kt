package com.example.fituai.designsystem

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout

class StepProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var currentStep: Int = 1
    private var totalSteps: Int = 5

    private var activeColor: Int = 0xFF6200EE.toInt() // fallback roxo
    private var inactiveColor: Int = 0xFFFF9800.toInt() // fallback laranja
    private var trackThicknessPx: Int = dpToPx(6)
    private var cornerRadiusPx: Int = -1 // -1 sinaliza "usar pill"
    private var animationDurationMs: Long = 400L
    private var segmentSpacingPx: Int = dpToPx(8)
    private var lastStep: Int = 0

    init {
        orientation = VERTICAL
        if (attrs != null) {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.StepProgressView)
            currentStep = ta.getInt(R.styleable.StepProgressView_currentStep, 1)
            totalSteps = ta.getInt(R.styleable.StepProgressView_totalSteps, 5)

            activeColor = ta.getColor(
                R.styleable.StepProgressView_ds_activeColor,
                activeColor
            )
            inactiveColor = ta.getColor(
                R.styleable.StepProgressView_ds_inactiveColor,
                inactiveColor
            )
            trackThicknessPx = ta.getDimensionPixelSize(
                R.styleable.StepProgressView_ds_segmentHeight,
                trackThicknessPx
            )
            // Se não informado, mantemos -1 para calcular como "pill" (metade da espessura)
            if (ta.hasValue(R.styleable.StepProgressView_ds_cornerRadius)) {
                cornerRadiusPx = ta.getDimensionPixelSize(
                    R.styleable.StepProgressView_ds_cornerRadius,
                    trackThicknessPx / 2
                )
            }
            segmentSpacingPx = ta.getDimensionPixelSize(
                R.styleable.StepProgressView_ds_segmentSpacing,
                segmentSpacingPx
            )
            animationDurationMs = ta.getInt(
                R.styleable.StepProgressView_ds_animationDuration,
                animationDurationMs.toInt()
            ).toLong()
            ta.recycle()
        }
        buildSegments()
        updateSegments(animated = false)
    }

    private fun buildSegments() {
        removeAllViews()
        val container = LinearLayout(context).apply {
            orientation = HORIZONTAL
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }
        for (i in 1..totalSteps) {
            val segment = View(context)
            segment.background = makeSegmentBackground(inactiveColor)
            val lp = LayoutParams(0, trackThicknessPx, 1f)
            if (i < totalSteps) lp.marginEnd = segmentSpacingPx
            segment.layoutParams = lp
            container.addView(segment)
        }
        addView(container)
    }

    fun setCurrentStep(step: Int) {
        currentStep = step.coerceIn(0, totalSteps)
        updateSegments(animated = true)
    }

    fun setTotalSteps(total: Int) {
        totalSteps = total.coerceAtLeast(0)
        if (currentStep > totalSteps) currentStep = totalSteps
        buildSegments()
        updateSegments(animated = false)
    }

    private fun updateSegments(animated: Boolean) {
        if (childCount == 0) return
        val container = getChildAt(0) as LinearLayout
        val radius = resolveCornerRadius()

        for (i in 0 until container.childCount) {
            val view = container.getChildAt(i)
            val stepIndex = i + 1
            val shouldBeActive = stepIndex <= currentStep
            val drawable = view.background as? GradientDrawable
                ?: makeSegmentBackground(inactiveColor).also { view.background = it }

            val currentColor = (drawable.color?.defaultColor) ?: inactiveColor
            val targetColor = if (shouldBeActive) activeColor else inactiveColor

            // Atualiza raio sempre (pode ter mudado via atributo)
            drawable.cornerRadius = radius.toFloat()

            if (animated) {
                // Apenas anima quando o estado mudou em relação ao lastStep
                val wasActive = stepIndex <= lastStep
                if (wasActive != shouldBeActive) {
                    animateColor(drawable, currentColor, targetColor)
                } else {
                    drawable.setColor(targetColor)
                }
            } else {
                drawable.setColor(targetColor)
            }
        }
        lastStep = currentStep
    }

    private fun animateColor(drawable: GradientDrawable, from: Int, to: Int) {
        val animator = ValueAnimator.ofObject(ArgbEvaluator(), from, to).apply {
            duration = animationDurationMs
            interpolator = DecelerateInterpolator()
            addUpdateListener { va ->
                val color = va.animatedValue as Int
                drawable.setColor(color)
            }
        }
        animator.start()
    }

    private fun resolveCornerRadius(): Int {
        return if (cornerRadiusPx >= 0) cornerRadiusPx else trackThicknessPx / 2
    }

    private fun makeSegmentBackground(color: Int): GradientDrawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = resolveCornerRadius().toFloat()
            setColor(color)
        }
    }

    private fun dpToPx(dp: Int): Int = (dp * resources.displayMetrics.density).toInt()
}
