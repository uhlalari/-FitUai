package com.example.fituai.designsystem

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.fituai.designsystem.R
import com.google.android.material.card.MaterialCardView

class MealSectionCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val cardRoot: MaterialCardView
    private val iconView: ImageView
    private val titleView: TextView
    private val ingestedView: TextView
    private val recommendedView: TextView
    private val actionButton: ImageButton

    init {
        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.ds_meal_section_card, this, true)

        cardRoot = findViewById(R.id.ds_card_root)
        iconView = findViewById(R.id.ds_icon)
        titleView = findViewById(R.id.ds_title)
        ingestedView = findViewById(R.id.ds_ingested)
        recommendedView = findViewById(R.id.ds_recommended)
        actionButton = findViewById(R.id.ds_action)

        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.MealSectionCardView)
            try {
                val iconRes = a.getResourceId(R.styleable.MealSectionCardView_ds_iconSrc, 0)
                if (iconRes != 0) iconView.setImageResource(iconRes)

                titleView.text = a.getString(R.styleable.MealSectionCardView_ds_titleText) ?: ""
                ingestedView.text = a.getString(R.styleable.MealSectionCardView_ds_ingestedText) ?: ""
                recommendedView.text = a.getString(R.styleable.MealSectionCardView_ds_recommendedText) ?: ""

                val actionIconRes = a.getResourceId(R.styleable.MealSectionCardView_ds_actionIcon, 0)
                if (actionIconRes != 0) actionButton.setImageResource(actionIconRes)

                // Colors (optional)
                val titleColor = a.getColor(R.styleable.MealSectionCardView_ds_titleTextColor, -1)
                if (titleColor != -1) titleView.setTextColor(titleColor)

                val secondaryColor = a.getColor(R.styleable.MealSectionCardView_ds_secondaryTextColor, -1)
                if (secondaryColor != -1) {
                    ingestedView.setTextColor(secondaryColor)
                    recommendedView.setTextColor(secondaryColor)
                }

                val cardColor = a.getColor(R.styleable.MealSectionCardView_ds_cardBackgroundColor, -1)
                if (cardColor != -1) cardRoot.setCardBackgroundColor(cardColor)
            } finally {
                a.recycle()
            }
        }
    }

    fun setOnActionClick(listener: OnClickListener?) {
        actionButton.setOnClickListener(listener)
    }

    fun setTitle(text: CharSequence) { titleView.text = text }
    fun setIngested(text: CharSequence) { ingestedView.text = text }
    fun setRecommended(text: CharSequence) { recommendedView.text = text }
    fun setIcon(resId: Int) { iconView.setImageResource(resId) }
    fun setActionIcon(resId: Int) { actionButton.setImageResource(resId) }
}
