package com.example.fituai.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.fituai.R
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
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_food, parent, false)

        val foodItem = getItem(position) as FoodItem

        val ivFood = view.findViewById<ImageView>(R.id.ivFood)
        val tvFoodName = view.findViewById<TextView>(R.id.tvFoodName)
        val tvFoodCalories = view.findViewById<TextView>(R.id.tvFoodCalories)
        val btnMinus = view.findViewById<Button>(R.id.btnMinus)
        val tvPortion = view.findViewById<TextView>(R.id.tvPortion)
        val btnPlus = view.findViewById<Button>(R.id.btnPlus)

        ivFood.setImageResource(foodItem.imageResId)
        tvFoodName.text = foodItem.name
        tvFoodCalories.text = "${foodItem.calories} Cal"

        var quantity = savedQuantities[foodItem.name] ?: 0
        tvPortion.text = "$quantity porções"

        btnPlus.setOnClickListener {
            quantity++
            tvPortion.text = "$quantity porções"
            onFoodItemUpdated(foodItem, quantity)
        }

        btnMinus.setOnClickListener {
            if (quantity > 0) {
                quantity--
                tvPortion.text = "$quantity porções"
                onFoodItemUpdated(foodItem, quantity)
            }
        }

        return view
    }
}
