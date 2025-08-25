package com.example.fituai.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fituai.R
import com.example.fituai.data.local.MockRecipeDatabase
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.domain.usecase.CalculateTDEE
import com.example.fituai.presentation.adapter.ImageCarouselAdapter
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import com.example.fituai.designsystem.MealSectionCardView
import com.example.fituai.designsystem.WaterCardView

class HomeActivity : AppCompatActivity() {

    private lateinit var repository: FitnessRepository

    private lateinit var progressCalorias: ProgressBar
    private lateinit var progressCarb: ProgressBar
    private lateinit var progressProt: ProgressBar
    private lateinit var progressGord: ProgressBar
    private lateinit var tvIngestaoNutricional: TextView
    private lateinit var tvCarbValues: TextView
    private lateinit var tvProtValues: TextView
    private lateinit var tvGordValues: TextView
    private lateinit var waterCard: WaterCardView
    private lateinit var bannerViewPager: ViewPager2
    private lateinit var dotsContainer: LinearLayout
    private lateinit var dots: Array<ImageView>

    // Design System meal cards
    private lateinit var snackCard: MealSectionCardView
    private lateinit var foodCard: MealSectionCardView
    private lateinit var dinnerCard: MealSectionCardView

    private var totalCaloriesConsumed = 0.0
    private val selectedDate = Calendar.getInstance()

    private val imageList = listOf(
        R.drawable.ic_banner_receita_sugerida,
        R.drawable.ic_banner_mundo_esporte,
        R.drawable.ic_banner_tecnologia_saude,
        R.drawable.ic_banner_noite_sono,
        R.drawable.ic_banner_artigos_uteis
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        repository = FitnessRepository(applicationContext)

        setupUI()
        setupListeners()
        setupBannerCarousel()
        updateDateView()
    }

    override fun onResume() {
        super.onResume()
        refreshDataForDate()
    }

    private fun setupUI() {
        progressCalorias = findViewById(R.id.progressCalorias)
        progressCarb = findViewById(R.id.progressCarb)
        progressProt = findViewById(R.id.progressProt)
        progressGord = findViewById(R.id.progressGord)
        tvIngestaoNutricional = findViewById(R.id.tvIngestaoNutricional)
        tvCarbValues = findViewById(R.id.tvCarbValues)
        tvProtValues = findViewById(R.id.tvProtValues)
        tvGordValues = findViewById(R.id.tvGordValues)
        bannerViewPager = findViewById(R.id.bannerViewPager)

        // Cards do Design System
        snackCard = findViewById(R.id.addSnackCard)
        foodCard = findViewById(R.id.addFoodCard)
        dinnerCard = findViewById(R.id.addDinnerCard)
        waterCard = findViewById(R.id.waterCard)
    }

    private fun setupListeners() {
        findViewById<ImageButton>(R.id.btnMenu).setOnClickListener {
            findViewById<DrawerLayout>(R.id.drawerLayout).openDrawer(GravityCompat.START)
        }

        findViewById<NavigationView>(R.id.navigationView).setNavigationItemSelectedListener {
            if (it.itemId == R.id.menu_editar_formulario) {
                startActivity(Intent(this, FormActivity::class.java))
                findViewById<DrawerLayout>(R.id.drawerLayout).closeDrawer(GravityCompat.START)
                true
            } else false
        }

        fun updateAndRefreshDate(offset: Int) {
            selectedDate.add(Calendar.DATE, offset)
            updateDateView()
            refreshDataForDate()
        }

        findViewById<ImageButton>(R.id.btnPreviousDay).setOnClickListener { updateAndRefreshDate(-1) }
        findViewById<ImageButton>(R.id.btnNextDay).setOnClickListener { updateAndRefreshDate(1) }

        snackCard.setOnActionClick {
            val dateStr = getFormattedDate()
            startActivity(
                Intent(this, AddFoodActivity::class.java)
                    .putExtra("selectedDate", dateStr)
                    .putExtra("tipoRefeicao", "Lanche")
            )
        }
        foodCard.setOnActionClick {
            val dateStr = getFormattedDate()
            startActivity(
                Intent(this, AddFoodActivity::class.java)
                    .putExtra("selectedDate", dateStr)
                    .putExtra("tipoRefeicao", "Almoco")
            )
        }
        dinnerCard.setOnActionClick {
            val dateStr = getFormattedDate()
            startActivity(
                Intent(this, AddFoodActivity::class.java)
                    .putExtra("selectedDate", dateStr)
                    .putExtra("tipoRefeicao", "Jantar")
            )
        }

        waterCard.setOnRightActionClick {
            lifecycleScope.launch {
                repository.updateWaterIntake(getFormattedDate(), 200)
                updateWaterUI()
            }
        }

        waterCard.setOnLeftActionClick {
            lifecycleScope.launch {
                repository.updateWaterIntake(getFormattedDate(), -200)
                updateWaterUI()
            }
        }
    }

    private fun getFormattedDate(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return sdf.format(selectedDate.time)
    }

    private fun updateDateView() {
        val dateTextView = findViewById<TextView>(R.id.tvSelectedDate)
        val today = Calendar.getInstance()
        val label = if (SimpleDateFormat("dd/MM/yyyy").format(today.time) == getFormattedDate())
            "Hoje, ${getFormattedDate()}" else getFormattedDate()
        dateTextView.text = label
    }

    private fun refreshDataForDate() {
        lifecycleScope.launch {
            val entries = repository.getFoodEntriesByDate(getFormattedDate())
            val userData = repository.getUserData()
            val tdee = userData?.let { CalculateTDEE().execute(it) } ?: 2000.0

            val recomendado = mapOf(
                "Lanche" to (tdee * 0.25).toInt(),
                "Almoco" to (tdee * 0.4).toInt(),
                "Jantar" to (tdee * 0.35).toInt()
            )

            val ingerido = mapOf(
                "Lanche" to entries.filter { it.mealType == "Lanche" }
                    .sumOf { it.calories * it.quantity },
                "Almoco" to entries.filter { it.mealType == "Almoco" }
                    .sumOf { it.calories * it.quantity },
                "Jantar" to entries.filter { it.mealType == "Jantar" }
                    .sumOf { it.calories * it.quantity }
            )

            snackCard.setIngested("Ingerido: ${ingerido["Lanche"] ?: 0} kcal")
            snackCard.setRecommended("Recomendado: ${recomendado["Lanche"] ?: 0} kcal")

            foodCard.setIngested("Ingerido: ${ingerido["Almoco"] ?: 0} kcal")
            foodCard.setRecommended("Recomendado: ${recomendado["Almoco"] ?: 0} kcal")

            dinnerCard.setIngested("Ingerido: ${ingerido["Jantar"] ?: 0} kcal")
            dinnerCard.setRecommended("Recomendado: ${recomendado["Jantar"] ?: 0} kcal")

            val totalCalories = entries.sumOf { it.calories * it.quantity }
            val totalCarbs = entries.sumOf { it.carbs * it.quantity }
            val totalProtein = entries.sumOf { it.protein * it.quantity }
            val totalFat = entries.sumOf { it.fat * it.quantity }

            totalCaloriesConsumed = totalCalories.toDouble()

            progressCalorias.progress = totalCalories
            progressCarb.progress = totalCarbs
            progressProt.progress = totalProtein
            progressGord.progress = totalFat

            tvIngestaoNutricional.text = "Ingestão Nutricional: $totalCalories/${tdee.toInt()} kcal"
            tvCarbValues.text = "$totalCarbs/300g"
            tvProtValues.text = "$totalProtein/150g"
            tvGordValues.text = "$totalFat/70g"

            updateWaterUI()
        }
    }

    private fun updateWaterUI() {
        lifecycleScope.launch {
            val waterMl = repository.getWaterIntakeByDate(getFormattedDate())
            waterCard.setTitle("Água: ${waterMl}ml")
        }
    }

    private fun setupBannerCarousel() {
        val adapter = ImageCarouselAdapter(imageList) { showBannerBottomSheet(it) }
        bannerViewPager.adapter = adapter

        bannerViewPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 1
            setPadding(0, 0, 64, 0)
            getChildAt(0)?.let {
                (it as? RecyclerView)?.clipToPadding = false
                it.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            }
            setPageTransformer { page, position -> page.translationX = -position * 40f }
        }

        bannerViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bannerViewPager.setPadding(if (position == imageList.lastIndex) 64 else 0, 0, 64, 0)
            }
        })
    }

    private fun showBannerBottomSheet(position: Int) {
        if (position == 0) {
            val receitas = MockRecipeDatabase.receitas
            val index = (selectedDate.get(Calendar.DAY_OF_YEAR) % receitas.size)
            val receita = receitas[index]

            val description = buildString {
                append("🍽️ *${receita.name}*\n\n")
                append("📌 Categoria: ${receita.category}\n")
                append("⏱️ Tempo de preparo: ${receita.preparationTimeMinutes} min\n")
                append("🔥 Calorias por porção: ${receita.caloriesPerServing} kcal\n")
                append("👥 Porções: ${receita.servings}\n\n")
                append("📋 Ingredientes:\n")
                receita.ingredients.forEach { append("• $it\n") }
                append("\n👩‍🍳 Modo de preparo:\n")
                receita.preparationSteps.forEachIndexed { i, passo ->
                    append("${i + 1}. $passo\n")
                }
            }

            val bottomSheet = CarouselBottomSheet.newInstance(
                R.drawable.ic_banner_receita_sugerida,
                description
            )
            bottomSheet.show(supportFragmentManager, "BannerBottomSheet")

        } else {
            val imageResId = imageList[position]
            val description = when (position) {
                1 -> "Mundo do esporte: como manter o corpo ativo e a mente saudável."
                2 -> "Tecnologia e saúde: descubra inovações para melhorar seu bem-estar."
                3 -> "Uma noite de sono: a importância do descanso para sua saúde."
                4 -> "Artigos úteis: informações para transformar seu estilo de vida."
                else -> ""
            }

            val bottomSheet = CarouselBottomSheet.newInstance(imageResId, description)
            bottomSheet.show(supportFragmentManager, "BannerBottomSheet")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
