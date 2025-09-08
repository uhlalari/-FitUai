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

class WaterCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val cardRoot: MaterialCardView
    private val iconView: ImageView
    private val titleView: TextView
    private val leftAction: ImageButton
    private val rightAction: ImageButton

    init {
        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.ds_water_card, this, true)

        cardRoot = findViewById(R.id.ds_water_card_root)
        iconView = findViewById(R.id.ds_icon)
        titleView = findViewById(R.id.ds_title)
        leftAction = findViewById(R.id.ds_left_action)
        rightAction = findViewById(R.id.ds_right_action)

        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.WaterCardView)
            try {
                val iconRes = a.getResourceId(R.styleable.WaterCardView_ds_iconSrc, 0)
                if (iconRes != 0) iconView.setImageResource(iconRes)

                titleView.text = a.getString(R.styleable.WaterCardView_ds_titleText) ?: ""

                val leftIcon = a.getResourceId(R.styleable.WaterCardView_ds_leftActionIcon, 0)
                if (leftIcon != 0) leftAction.setImageResource(leftIcon)

                val rightIcon = a.getResourceId(R.styleable.WaterCardView_ds_rightActionIcon, 0)
                if (rightIcon != 0) rightAction.setImageResource(rightIcon)

                val titleColor = a.getColor(R.styleable.WaterCardView_ds_titleTextColor, -1)
                if (titleColor != -1) titleView.setTextColor(titleColor)

                val cardColor = a.getColor(R.styleable.WaterCardView_ds_cardBackgroundColor, -1)
                if (cardColor != -1) cardRoot.setCardBackgroundColor(cardColor)
            } finally {
                a.recycle()
            }
        }
    }

    fun setOnLeftActionClick(listener: OnClickListener?) { leftAction.setOnClickListener(listener) }
    fun setOnRightActionClick(listener: OnClickListener?) { rightAction.setOnClickListener(listener) }

    fun setTitle(text: CharSequence) { titleView.text = text }
    fun setIcon(resId: Int) { iconView.setImageResource(resId) }
    fun setLeftActionIcon(resId: Int) { leftAction.setImageResource(resId) }
    fun setRightActionIcon(resId: Int) { rightAction.setImageResource(resId) }
}
