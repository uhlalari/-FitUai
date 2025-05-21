package com.example.fituai.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.fituai.R
import com.example.fituai.data.repository.FitnessRepository
import com.example.fituai.presentation.adapter.ImageCarouselAdapter
import kotlinx.coroutines.launch

class CheeseGraphActivity : AppCompatActivity() {

    private lateinit var ivGraph: ImageView
    private lateinit var tvCalorieMessage: TextView
    private lateinit var btnAddFood: Button
    private lateinit var bannerViewPager: ViewPager2
    private lateinit var dotsContainer: LinearLayout
    private lateinit var repository: FitnessRepository

    private var tdee: Double = 0.0
    private var totalCaloriesConsumed: Double = 0.0
    private lateinit var dots: Array<ImageView>

    private val imageList = listOf(
        R.drawable.ic_banner_receita_sugerida,
        R.drawable.ic_banner_mundo_esporte,
        R.drawable.ic_banner_tecnologia_saude,
        R.drawable.ic_banner_noite_sono,
        R.drawable.ic_banner_artigos_uteis
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheese_graph)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Consumo Diário"
        }

        repository = FitnessRepository(applicationContext)

        ivGraph = findViewById(R.id.ivGraph)
        tvCalorieMessage = findViewById(R.id.tvCalorieMessage)
        btnAddFood = findViewById(R.id.btnAddFood)
        bannerViewPager = findViewById(R.id.bannerViewPager)
        dotsContainer = findViewById(R.id.dotsContainer)

        tdee = intent.getDoubleExtra("TDEE", 0.0)

        setupBannerCarousel()

        btnAddFood.setOnClickListener {
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val entries = repository.getAllFoodEntries()
            totalCaloriesConsumed = entries.sumOf { it.calories * it.quantity }.toDouble()
            updateGraph()
        }
    }

    private fun setupBannerCarousel() {
        val adapter = ImageCarouselAdapter(imageList) { position ->
            showBannerBottomSheet(position)
        }

        bannerViewPager.adapter = adapter

        bannerViewPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 1
            setPadding(0, 0, 64, 0)

            getChildAt(0)?.let { recyclerView ->
                (recyclerView as? RecyclerView)?.clipToPadding = false
                recyclerView.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            }

            setPageTransformer { page, position ->
                page.translationX = -position * 40f
            }
        }

        setupDots(imageList.size)
        updateDots(0)

        bannerViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateDots(position)

                if (position == imageList.lastIndex) {
                    bannerViewPager.setPadding(64, 0, 0, 0)
                } else {
                    bannerViewPager.setPadding(0, 0, 64, 0)
                }
            }
        })
    }

    private fun setupDots(size: Int) {
        dots = Array(size) { ImageView(this) }
        dotsContainer.removeAllViews()

        for (i in dots.indices) {
            dots[i] = ImageView(this).apply {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        this@CheeseGraphActivity,
                        R.drawable.dot_inactive
                    )
                )
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(4, 0, 4, 0)
                layoutParams = params
            }
            dotsContainer.addView(dots[i])
        }
    }

    private fun updateDots(currentPosition: Int) {
        for (i in dots.indices) {
            val drawableId = if (i == currentPosition) R.drawable.dot_active else R.drawable.dot_inactive
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, drawableId))
        }
    }

    private fun updateGraph() {
        val percentageConsumed = if (tdee > 0) (totalCaloriesConsumed / tdee) * 100 else 0.0
        val cheeseIndex = when {
            percentageConsumed >= 150 -> 11
            percentageConsumed >= 100 -> 10
            percentageConsumed >= 90 -> 9
            percentageConsumed >= 80 -> 8
            percentageConsumed >= 70 -> 7
            percentageConsumed >= 60 -> 6
            percentageConsumed >= 50 -> 5
            percentageConsumed >= 40 -> 4
            percentageConsumed >= 30 -> 3
            percentageConsumed >= 20 -> 2
            percentageConsumed >= 10 -> 1
            percentageConsumed >= 0 -> 0
            else -> 1
        }

        val cheeseImageResId = resources.getIdentifier(
            "ic_icecream_$cheeseIndex",
            "drawable",
            packageName
        )
        ivGraph.setImageResource(cheeseImageResId)

        lifecycleScope.launch {
            val userData = repository.getUserData()
            val rawObjetivo = userData?.objetivo ?: "Manter Peso"
            val objetivo = when (rawObjetivo.lowercase()) {
                "perder peso" -> "emagrecer"
                "ganhar peso" -> "ganhar massa"
                "manter peso" -> "manter"
                else -> "manter"
            }

            val diferenca = (tdee - totalCaloriesConsumed).toInt()

            val mensagem = when (objetivo) {
                "emagrecer" -> {
                    if (diferenca > 0) {
                        "Olá, você consumiu ${totalCaloriesConsumed.toInt()} calorias.\n" +
                                "Para atingir seu objetivo de emagrecimento, ainda pode consumir até $diferenca kcal hoje."
                    } else {
                        "Olá, você consumiu ${totalCaloriesConsumed.toInt()} calorias.\n" +
                                "Você ultrapassou em ${-diferenca} kcal o limite para emagrecimento hoje."
                    }
                }
                "ganhar massa" -> {
                    if (diferenca < 0) {
                        "Olá, você consumiu ${totalCaloriesConsumed.toInt()} calorias.\n" +
                                "Você ultrapassou sua meta calórica para ganhar massa em ${-diferenca} kcal. Ótimo!"
                    } else {
                        "Olá, você consumiu ${totalCaloriesConsumed.toInt()} calorias.\n" +
                                "Para ganhar massa, ainda precisa consumir mais $diferenca kcal hoje."
                    }
                }
                else -> {
                    if (diferenca > 0) {
                        "Olá, você consumiu ${totalCaloriesConsumed.toInt()} calorias.\n" +
                                "Para manter o peso, ainda pode consumir até $diferenca kcal hoje."
                    } else {
                        "Olá, você consumiu ${totalCaloriesConsumed.toInt()} calorias.\n" +
                                "Você ultrapassou sua meta de manutenção em ${-diferenca} kcal hoje."
                    }
                }
            }

            tvCalorieMessage.text = mensagem
        }
    }

    private fun showBannerBottomSheet(position: Int) {
        val imageResId = imageList[position]
        val description = when (position) {
            0 -> "Receita sugerida para hoje: inspire-se para uma refeição saudável!"
            1 -> "Mundo do esporte: como manter o corpo ativo e a mente saudável."
            2 -> "Tecnologia e saúde: descubra inovações para melhorar seu bem-estar."
            3 -> "Uma noite de sono: a importância do descanso para sua saúde."
            4 -> "Artigos úteis: informações para transformar seu estilo de vida."
            else -> ""
        }

        val bottomSheet = BannerDetailBottomSheet.newInstance(imageResId, description)
        bottomSheet.show(supportFragmentManager, "BannerBottomSheet")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
