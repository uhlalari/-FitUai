package com.example.fituai.presentation.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.fituai.R
import com.example.fituai.data.local.MockFoodDatabase
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.presentation.adapter.FoodAdapter
import kotlinx.coroutines.launch

class AddFoodActivity : AppCompatActivity() {

    private lateinit var foodListView: ListView
    private lateinit var btnContinue: Button
    private lateinit var repository: FitnessRepository
    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Adicionar Alimentos"
        }

        foodListView = findViewById(R.id.foodListView)
        btnContinue = findViewById(R.id.btnContinue)

        repository = FitnessRepository(applicationContext)

        lifecycleScope.launch {
            val entries = repository.getAllFoodEntries()
            val savedQuantities = entries.associate { it.foodName to it.quantity }

            adapter = FoodAdapter(
                this@AddFoodActivity,
                MockFoodDatabase.alimentos,
                savedQuantities
            ) { foodItem, quantity ->
                lifecycleScope.launch {
                    if (quantity == 0) {
                        repository.removeFoodEntry(foodItem.name)
                    } else {
                        repository.addFoodEntry(foodItem.name, quantity, foodItem.calories)
                    }
                }
            }

            foodListView.adapter = adapter
        }

        btnContinue.setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
