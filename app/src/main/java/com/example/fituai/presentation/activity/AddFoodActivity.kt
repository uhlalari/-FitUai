package com.example.fituai.presentation.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.fituai.R
import com.example.fituai.data.local.MockFoodDatabase
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.model.FoodItem
import com.example.fituai.presentation.adapter.FoodAdapter
import kotlinx.coroutines.launch

class AddFoodActivity : AppCompatActivity() {

    private lateinit var foodListView: ListView
    private lateinit var btnContinue: Button
    private lateinit var etSearchFood: EditText
    private lateinit var repository: FitnessRepository
    private lateinit var adapter: FoodAdapter
    private lateinit var selectedDate: String
    private lateinit var tipoRefeicao: String

    private var selectedQuantities: MutableMap<String, Int> = mutableMapOf()
    private var fullFoodList: List<FoodItem> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedDate = intent.getStringExtra("selectedDate") ?: FitnessRepository.getToday()
        tipoRefeicao = intent.getStringExtra("tipoRefeicao") ?: "Lanche"
        setContentView(R.layout.activity_add_food)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Adicionar Alimentos"
        }

        etSearchFood = findViewById(R.id.etSearchFood)
        foodListView = findViewById(R.id.foodListView)
        btnContinue = findViewById(R.id.btnContinue)

        repository = FitnessRepository(applicationContext)

        lifecycleScope.launch {
            fullFoodList = MockFoodDatabase.foods

            val entries = repository.getFoodEntriesByDate(selectedDate)
            selectedQuantities = entries.associate { it.foodName to it.quantity }.toMutableMap()

            setupAdapter(fullFoodList)

            etSearchFood.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE) {
                    performSearch()
                    true
                } else false
            }

            etSearchFood.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    performSearch()
                }

                override fun afterTextChanged(s: Editable?) {}
            })
        }

        btnContinue.setOnClickListener {
            finish()
        }
    }

    private fun setupAdapter(foodList: List<FoodItem>) {
        adapter = FoodAdapter(this, foodList, selectedQuantities) { foodItem, quantity ->
            selectedQuantities[foodItem.name] = quantity
            lifecycleScope.launch {
                if (quantity == 0) {
                    repository.removeFoodEntry(foodItem.name)
                } else {
                    repository.upsertFoodEntry(
                        foodName = foodItem.name,
                        quantity = quantity,
                        calories = foodItem.calories,
                        carbs = foodItem.carbs,
                        protein = foodItem.protein,
                        fat = foodItem.fat,
                        mealType = tipoRefeicao,
                        date = selectedDate
                    )
                }
            }
        }
        foodListView.adapter = adapter
    }

    private fun performSearch() {
        val query = etSearchFood.text.toString().trim()
        val filteredList = fullFoodList.filter {
            it.name.contains(query, ignoreCase = true)
        }
        setupAdapter(filteredList)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
