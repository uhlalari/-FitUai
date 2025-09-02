package com.example.fituai.core

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val PREFS_NAME = "fituai_prefs"
    private const val KEY_NOTIF_ENABLED = "daily_progress_notification_enabled"
    private const val KEY_LAST_STREAK_CELEBRATION_DATE = "last_streak_celebration_date"

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun isDailyNotificationEnabled(context: Context): Boolean =
        prefs(context).getBoolean(KEY_NOTIF_ENABLED, true)

    fun setDailyNotificationEnabled(context: Context, enabled: Boolean) {
        prefs(context).edit().putBoolean(KEY_NOTIF_ENABLED, enabled).apply()
    }

    fun getLastStreakCelebrationDate(context: Context): String? =
        prefs(context).getString(KEY_LAST_STREAK_CELEBRATION_DATE, null)

    fun setLastStreakCelebrationDate(context: Context, date: String) {
        prefs(context).edit().putString(KEY_LAST_STREAK_CELEBRATION_DATE, date).apply()
    }
}
