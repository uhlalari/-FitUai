package com.example.fituai.designsystem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.progressindicator.LinearProgressIndicator

class NutritionSummaryBannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val cardRoot: MaterialCardView
    private val titleView: TextView

    private val caloriesValue: TextView
    private val proteinValue: TextView
    private val carbsValue: TextView
    private val fatValue: TextView
    private val caloriesLabel: TextView
    private val proteinLabel: TextView
    private val carbsLabel: TextView
    private val fatLabel: TextView

    private val caloriesProgress: LinearProgressIndicator
    private val proteinProgress: LinearProgressIndicator
    private val carbsProgress: LinearProgressIndicator
    private val fatProgress: LinearProgressIndicator

    private var goalCalories: Int = 0
    private var goalProtein: Int = 0
    private var goalCarbs: Int = 0
    private var goalFat: Int = 0

    init {
        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.ds_nutrition_summary_banner, this, true)

        cardRoot = findViewById(R.id.ds_nutrition_banner_root)
        titleView = findViewById(R.id.ds_title)

        caloriesValue = findViewById(R.id.ds_value_calories)
        proteinValue = findViewById(R.id.ds_value_protein)
        carbsValue = findViewById(R.id.ds_value_carbs)
        fatValue = findViewById(R.id.ds_value_fat)
        caloriesLabel = findViewById(R.id.ds_label_calories)
        proteinLabel = findViewById(R.id.ds_label_protein)
        carbsLabel = findViewById(R.id.ds_label_carbs)
        fatLabel = findViewById(R.id.ds_label_fat)

        caloriesProgress = findViewById(R.id.ds_progress_calories)
        proteinProgress = findViewById(R.id.ds_progress_protein)
        carbsProgress = findViewById(R.id.ds_progress_carbs)
        fatProgress = findViewById(R.id.ds_progress_fat)

        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.NutritionSummaryBannerView)
            try {
                titleView.text = a.getString(R.styleable.NutritionSummaryBannerView_ds_titleText)
                    ?: resources.getString(R.string.ds_default_nutrition_title)

                val titleColor = a.getColor(R.styleable.NutritionSummaryBannerView_ds_titleTextColor, -1)
                if (titleColor != -1) titleView.setTextColor(titleColor)

                val cardBg = a.getColor(R.styleable.NutritionSummaryBannerView_ds_cardBackgroundColor, -1)
                if (cardBg != -1) cardRoot.setCardBackgroundColor(cardBg)

                goalCalories = a.getInt(R.styleable.NutritionSummaryBannerView_ds_goalCalories, 0)
                goalProtein = a.getInt(R.styleable.NutritionSummaryBannerView_ds_goalProtein, 0)
                goalCarbs = a.getInt(R.styleable.NutritionSummaryBannerView_ds_goalCarbs, 0)
                goalFat = a.getInt(R.styleable.NutritionSummaryBannerView_ds_goalFat, 0)

                // Inicializa textos das metas
                updateCalories(0)
                updateProtein(0)
                updateCarbs(0)
                updateFat(0)
            } finally {
                a.recycle()
            }
        }
    }

    // API pública
    fun setTitle(text: CharSequence) { titleView.text = text }
    fun setGoals(calories: Int, protein: Int, carbs: Int, fat: Int) {
        goalCalories = calories
        goalProtein = protein
        goalCarbs = carbs
        goalFat = fat
        // Recalcular textos com valor atual mantido
        updateCalories(getCurrentFromText(caloriesValue))
        updateProtein(getCurrentFromText(proteinValue))
        updateCarbs(getCurrentFromText(carbsValue))
        updateFat(getCurrentFromText(fatValue))
    }

    fun updateAll(calories: Int, protein: Int, carbs: Int, fat: Int) {
        updateCalories(calories)
        updateProtein(protein)
        updateCarbs(carbs)
        updateFat(fat)
    }

    fun updateCalories(value: Int) {
        caloriesValue.text = "${value}/${goalCalories} kcal"
        caloriesProgress.setProgressCompat(percent(value, goalCalories), true)
    }
    fun updateProtein(value: Int) {
        proteinValue.text = "${value}/${goalProtein} g"
        proteinProgress.setProgressCompat(percent(value, goalProtein), true)
    }
    fun updateCarbs(value: Int) {
        carbsValue.text = "${value}/${goalCarbs} g"
        carbsProgress.setProgressCompat(percent(value, goalCarbs), true)
    }
    fun updateFat(value: Int) {
        fatValue.text = "${value}/${goalFat} g"
        fatProgress.setProgressCompat(percent(value, goalFat), true)
    }

    // Customização de estilo (não impõe tema)
    fun setCardBackgroundColor(colorInt: Int) { cardRoot.setCardBackgroundColor(colorInt) }
    fun setTitleTextColor(colorInt: Int) { titleView.setTextColor(colorInt) }
    fun setLabelsTextColor(colorInt: Int) {
        caloriesLabel.setTextColor(colorInt)
        proteinLabel.setTextColor(colorInt)
        carbsLabel.setTextColor(colorInt)
        fatLabel.setTextColor(colorInt)
    }
    fun setValuesTextColor(colorInt: Int) {
        caloriesValue.setTextColor(colorInt)
        proteinValue.setTextColor(colorInt)
        carbsValue.setTextColor(colorInt)
        fatValue.setTextColor(colorInt)
    }
    fun setProgressColors(
        caloriesColor: Int,
        proteinColor: Int,
        carbsColor: Int,
        fatColor: Int,
        trackColor: Int
    ) {
        caloriesProgress.setIndicatorColor(caloriesColor)
        proteinProgress.setIndicatorColor(proteinColor)
        carbsProgress.setIndicatorColor(carbsColor)
        fatProgress.setIndicatorColor(fatColor)
        caloriesProgress.trackColor = trackColor
        proteinProgress.trackColor = trackColor
        carbsProgress.trackColor = trackColor
        fatProgress.trackColor = trackColor
    }

    // Utilidades
    private fun percent(value: Int, goal: Int): Int {
        if (goal <= 0) return 0
        val p = (value.toFloat() / goal.toFloat()) * 100f
        return p.coerceIn(0f, 100f).toInt()
    }

    private fun getCurrentFromText(textView: TextView): Int {
        // Formatos: "v/meta kcal" ou "v/meta g"
        val raw = textView.text?.toString() ?: return 0
        val slash = raw.indexOf('/')
        if (slash <= 0) return 0
        return raw.substring(0, slash).trim().toIntOrNull() ?: 0
    }
}
