package com.example.fituai.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodItem(
    val name: String,
    val calories: Int,
    val imageResId: Int
) : Parcelable
