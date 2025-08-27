package com.example.fituai.presentation.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import androidx.core.content.ContextCompat
import com.example.fituai.R
import com.example.fituai.designsystem.R as DsR
import com.example.fituai.domain.model.FoodItem

class FoodAdapter(
    private val context: Context,
    private val foodList: List<FoodItem>,
    private val savedQuantities: Map<String, Int>,
    private val onFoodItemUpdated: (FoodItem, Int) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = foodList.size

    override fun getItem(position: Int): Any = foodList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =
            convertView ?: LayoutInflater.from(context).inflate(DsR.layout.ds_food_item, parent, false)

        val foodItem = getItem(position) as FoodItem

        val colorPurple = ContextCompat.getColor(context, R.color.purple)
        val colorOrange = ContextCompat.getColor(context, R.color.orange)
        val colorBeige = ContextCompat.getColor(context, R.color.neutral100)

        (view as? MaterialCardView)?.setCardBackgroundColor(colorBeige)

        val tvFoodName = view.findViewById<TextView>(DsR.id.tvFoodName)
        val tvFoodCalories = view.findViewById<TextView>(DsR.id.tvFoodCalories)
        val btnMinus = view.findViewById<MaterialButton>(DsR.id.btnMinus)
        val tvPortion = view.findViewById<TextView>(DsR.id.tvPortion)
        val btnPlus = view.findViewById<MaterialButton>(DsR.id.btnPlus)

        tvFoodName.text = foodItem.name
        tvFoodCalories.text = "${foodItem.calories} Cal"

        tvFoodName.setTextColor(colorPurple)
        tvFoodCalories.setTextColor(colorPurple)
        tvPortion.setTextColor(colorPurple)

        btnPlus.text = ""
        btnPlus.setIconResource(R.drawable.ic_add)
        btnPlus.iconTint = ColorStateList.valueOf(colorOrange)
        btnPlus.iconPadding = 0
        btnPlus.setPadding(0, 0, 0, 0)
        btnPlus.minimumWidth = 0
        btnPlus.minimumHeight = 0
        btnPlus.iconGravity = MaterialButton.ICON_GRAVITY_TEXT_START
        btnPlus.iconSize = (context.resources.displayMetrics.density * 20f).toInt()
        btnPlus.strokeWidth = 0
        btnPlus.strokeColor = ColorStateList.valueOf(Color.TRANSPARENT)
        btnPlus.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)

        btnMinus.text = ""
        btnMinus.setIconResource(R.drawable.ic_circle)
        btnMinus.iconTint = ColorStateList.valueOf(colorOrange)
        btnMinus.iconPadding = 0
        btnMinus.setPadding(0, 0, 0, 0)
        btnMinus.minimumWidth = 0
        btnMinus.minimumHeight = 0
        btnMinus.iconGravity = MaterialButton.ICON_GRAVITY_TEXT_START
        btnMinus.iconSize = (context.resources.displayMetrics.density * 20f).toInt()
        btnMinus.strokeWidth = 0
        btnMinus.strokeColor = ColorStateList.valueOf(Color.TRANSPARENT)
        btnMinus.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)

        var quantity = savedQuantities[foodItem.name] ?: 0

        tvPortion.text = "$quantity porções"

        btnPlus.setOnClickListener {
            quantity += 1
            tvPortion.text = "$quantity porções"
            onFoodItemUpdated(foodItem, quantity)
        }

        btnMinus.setOnClickListener {
            if (quantity > 0) {
                quantity -= 1
                tvPortion.text = "$quantity porções"
                onFoodItemUpdated(foodItem, quantity)
            }
        }

        return view
    }
}
