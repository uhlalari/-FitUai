package com.example.fituai.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fituai.R
import com.example.fituai.data.local.MockRecipeDatabase
import com.example.fituai.data.local.MockSportsTipsDatabase
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
import com.example.fituai.designsystem.NutritionSummaryBannerView
import android.graphics.Color
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.fituai.core.AppPreferences
import com.example.fituai.notification.NotificationHelper
import android.animation.ObjectAnimator
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView as AndroidTextView
import android.view.animation.AccelerateInterpolator
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {

    private lateinit var repository: FitnessRepository

    private lateinit var nutritionBanner: NutritionSummaryBannerView
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

        // Edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val content = findViewById<View>(android.R.id.content)
        // Fundo claro sob a status bar e ícones escuros para acompanhar o tema do app
        content.setBackgroundResource(R.color.white)
        WindowInsetsControllerCompat(window, content).apply {
            isAppearanceLightStatusBars = true  // ícones escuros
            isAppearanceLightNavigationBars = true
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView?>(R.id.navigationView)
        val scrollContent = drawer.getChildAt(0) // ScrollView

        // Aplicar insets apenas nos alvos certos
        ViewCompat.setOnApplyWindowInsetsListener(drawer) { _, insets ->
            val sb = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Top/bottom no conteúdo rolável
            scrollContent?.setPadding(sb.left, sb.top, sb.right, sb.bottom)
            // Apenas top no NavigationView para não sobrepor o header
            navView?.setPadding(
                navView.paddingLeft,
                sb.top,
                navView.paddingRight,
                navView.paddingBottom
            )
            insets
        }

        repository = FitnessRepository(applicationContext)

        navView?.menu?.findItem(R.id.menu_toggle_notification)?.isChecked =
            AppPreferences.isDailyNotificationEnabled(this)

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
        nutritionBanner = findViewById(R.id.dsNutritionBanner)
        // Estética igual ao card anterior (fundo roxo, textos brancos, cores de progresso)
        nutritionBanner.setCardBackgroundColor(getColor(R.color.purple))
        nutritionBanner.setTitleTextColor(Color.WHITE)
        nutritionBanner.setLabelsTextColor(Color.WHITE)
        nutritionBanner.setValuesTextColor(Color.WHITE)
        nutritionBanner.setProgressColors(
            caloriesColor = getColor(R.color.orange),
            proteinColor = getColor(R.color.yellow),
            carbsColor = getColor(R.color.yellow),
            fatColor = getColor(R.color.yellow),
            trackColor = getColor(R.color.purple_light)
        )
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
            when (it.itemId) {
                R.id.menu_editar_formulario -> {
                    startActivity(Intent(this, FormActivity::class.java))
                    findViewById<DrawerLayout>(R.id.drawerLayout).closeDrawer(GravityCompat.START)
                    true
                }
                R.id.menu_toggle_notification -> {
                    val newChecked = !it.isChecked
                    it.isChecked = newChecked
                    AppPreferences.setDailyNotificationEnabled(this, newChecked)
                    if (newChecked && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 100)
                        }
                    }
                    refreshDataForDate()
                    true
                }
                else -> false
            }
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

            // Metas e valores (mantendo regras de negócio)
            nutritionBanner.setGoals(
                calories = tdee.toInt(),
                protein = 150,
                carbs = 300,
                fat = 70
            )
            nutritionBanner.updateAll(
                calories = totalCalories,
                protein = totalProtein,
                carbs = totalCarbs,
                fat = totalFat
            )
            nutritionBanner.setTitle("Ingestão Nutricional: ${totalCalories}/${tdee.toInt()} kcal")

            updateWaterUI()

            updateDailyNotification(entries.isNotEmpty(), totalCalories, tdee.toInt())

            // Celebrar streak de alimentos com "confetes" (emojis de alimentos)
            val streak = computeFoodStreakDays()
            val today = FitnessRepository.getToday()
            val lastCelebration = AppPreferences.getLastStreakCelebrationDate(this@HomeActivity)
            if (streak >= 5 && lastCelebration != today) {
                launchFoodEmojiConfetti()
                AppPreferences.setLastStreakCelebrationDate(this@HomeActivity, today)
            }
        }
    }

    private fun updateDailyNotification(hasEntriesToday: Boolean, consumed: Int, goal: Int) {
        val notificationsEnabled = AppPreferences.isDailyNotificationEnabled(this)
        val isToday = getFormattedDate() == FitnessRepository.getToday()
        if (notificationsEnabled && isToday && hasEntriesToday) {
            NotificationHelper.showDailyProgress(this, consumed, goal)
        } else {
            NotificationHelper.cancelDailyProgress(this)
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
                1 -> {
                    val tips = MockSportsTipsDatabase.tips
                    val idx = (selectedDate.get(Calendar.DAY_OF_YEAR) % tips.size)
                    val tip = tips[idx]
                    buildString {
                        append("📌 *Dica do dia: ${tip.title}*\n\n")
                        append("📋 Por que é importante?\n")
                        append("${tip.why}\n\n")
                        append("🔥 Como aplicar agora\n")
                        tip.how.forEach { append("• $it\n") }
                        if (!tip.note.isNullOrBlank()) {
                            append("\n📝 ${tip.note}\n")
                        }
                    }
                }
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

    // Calcula quantos dias consecutivos (incluindo hoje) o usuário registrou algum alimento
    private suspend fun computeFoodStreakDays(): Int {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val cal = Calendar.getInstance()
        var streak = 0
        while (true) {
            val dateStr = sdf.format(cal.time)
            val entries = repository.getFoodEntriesByDate(dateStr)
            if (entries.isEmpty()) break
            streak += 1
            cal.add(Calendar.DATE, -1)
        }
        return streak
    }

    // Animação nativa de "chuva" de emojis de alimentos (sem dependências externas)
    private fun launchFoodEmojiConfetti() {
        val root = findViewById<ViewGroup>(android.R.id.content) as FrameLayout

        // Lista somente com emojis de alimentos
        val foodEmojis = listOf(
            "🍎", "🍌", "🍇", "🥑", "🍓", "🍉", "🍍", "🍒",
            "🥕", "🌽", "🍞", "🧀", "🍗", "🍣", "🍕", "🍫", "🍪", "🥦", "🍊", "🍋"
        )

        // Garante medidas antes de posicionar
        if (root.width == 0 || root.height == 0) {
            root.post { launchFoodEmojiConfetti() }
            return
        }

        val count = 36 // quantidade moderada para não pesar
        val views = mutableListOf<AndroidTextView>()

        repeat(count) {
            val tv = AndroidTextView(this).apply {
                text = foodEmojis.random()
                textSize = Random.nextInt(16, 26).toFloat()
                alpha = Random.nextFloat().coerceIn(0.75f, 1f)
            }
            val lp = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
            root.addView(tv, lp)

            // Posição inicial aleatória no eixo X, um pouco acima do topo
            val startX = Random.nextInt(0, root.width).toFloat()
            val endY = root.height + Random.nextInt(80, 200)
            val driftX = Random.nextInt(-120, 121) // deriva lateral
            val startRotation = Random.nextInt(-30, 31).toFloat()
            val rotationDelta = Random.nextInt(60, 181) * if (Random.nextBoolean()) 1 else -1
            val duration = Random.nextLong(1200L, 2300L)
            val delay = Random.nextLong(0L, 400L)

            tv.translationX = startX
            tv.translationY = -Random.nextInt(50, 200).toFloat()
            tv.rotation = startRotation

            // Queda vertical
            val fall = ObjectAnimator.ofFloat(tv, View.TRANSLATION_Y, tv.translationY, endY.toFloat()).apply {
                this.duration = duration
                interpolator = AccelerateInterpolator(1.2f)
                startDelay = delay
            }
            // Leve deriva no X
            val sway = ObjectAnimator.ofFloat(tv, View.TRANSLATION_X, startX, startX + driftX).apply {
                this.duration = duration
                interpolator = AccelerateInterpolator(1.0f)
                startDelay = delay
            }
            // Rotação
            val spin = ObjectAnimator.ofFloat(tv, View.ROTATION, startRotation, startRotation + rotationDelta).apply {
                this.duration = duration
                interpolator = AccelerateInterpolator(1.0f)
                startDelay = delay
            }

            fall.start()
            sway.start()
            spin.start()

            // Remoção segura ao final (usa o maior duration+delay como referência)
            tv.postDelayed({
                root.removeView(tv)
            }, delay + duration + 100)

            views.add(tv)
        }
    }
}
