package com.grow.richdadpoordad.bangla.utils
/*
**************************************************
*        📱 Mobile App Developer - Tanvir         *
*------------------------------------------------ *
*  🚀 Native & Hybrid App Development Expert      *
*  💼 Tech Stack: Flutter | Jetpack | Firebase    *
*  📧 Email: dev.tanvirchy269@gmail.com           *
*  🌐 GitHub: https://github.com/tanvir-chy-ahmed *
*  📍 Location: Bangladesh                        *
*                                                 *
*  Need an app? Let’s build something great!      *
**************************************************
*/
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(
        PREFS_NAME,
        Context.MODE_PRIVATE
    )

    var isFirstLaunch: Boolean
        get() = prefs.getBoolean(KEY_FIRST_LAUNCH, true)
        set(value) = prefs.edit { putBoolean(KEY_FIRST_LAUNCH, value) }

    var selectedLanguage: String
        get() = prefs.getString(KEY_LANGUAGE, DEFAULT_LANGUAGE) ?: DEFAULT_LANGUAGE
        set(value) {
            prefs.edit {
                putString(KEY_LANGUAGE, value)
                putBoolean(KEY_FIRST_LAUNCH, false)
            }
        }

    var lastReadChapter: Int
        get() = prefs.getInt(KEY_LAST_CHAPTER, 1)
        set(value) = prefs.edit { putInt(KEY_LAST_CHAPTER, value) }

    var lastReadPage: Int
        get() = prefs.getInt(KEY_LAST_PAGE, 1)
        set(value) = prefs.edit { putInt(KEY_LAST_PAGE, value) }

    companion object {
        private const val PREFS_NAME = "rich_dad_poor_dad_prefs"
        private const val KEY_LANGUAGE = "selected_language"
        private const val KEY_LAST_CHAPTER = "last_chapter"
        private const val KEY_LAST_PAGE = "last_page"
        private const val KEY_FIRST_LAUNCH = "first_launch"

        const val DEFAULT_LANGUAGE = "en"
    }
} 