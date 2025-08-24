package com.example.fituai.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.fituai.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
            val formularioPreenchido = prefs.getBoolean("formulario_preenchido", false)

            val intent = if (formularioPreenchido) {
                Intent(this, HomeActivity::class.java)
            } else {
                Intent(this, FormActivity::class.java)
            }

            startActivity(intent)
            finish()
        }, 2000) // 2 segundos
    }
}
