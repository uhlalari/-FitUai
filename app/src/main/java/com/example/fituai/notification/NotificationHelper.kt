package com.example.fituai.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.fituai.R

internal object NotificationHelper {
    const val CHANNEL_ID = "daily_progress_channel"
    private const val CHANNEL_NAME = "Progresso diário"
    private const val CHANNEL_DESC = "Notificações com o progresso diário de calorias"
    const val NOTIFICATION_ID = 1001

    fun ensureChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = CHANNEL_DESC
                enableVibration(false)
                enableLights(false)
                lightColor = Color.TRANSPARENT
                setShowBadge(false)
            }
            val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(channel)
        }
    }

    fun showDailyProgress(context: Context, consumed: Int, goal: Int) {
        ensureChannel(context)
        val percent = if (goal > 0) ((consumed.toFloat() / goal.toFloat()) * 100).toInt().coerceIn(0, 100) else 0

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_banana)
            .setContentTitle(context.getString(R.string.notification_daily_progress_title))
            .setContentText("${consumed}/${goal} kcal")
            .setOnlyAlertOnce(true)
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setProgress(100, percent, false)

        try {
            NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
        } catch (e: SecurityException) {
        }
    }

    fun cancelDailyProgress(context: Context) {
        NotificationManagerCompat.from(context).cancel(NOTIFICATION_ID)
    }
}
