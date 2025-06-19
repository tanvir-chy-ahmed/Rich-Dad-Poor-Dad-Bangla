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
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.Locale

object LocaleHelper {
    @SuppressLint("ObsoleteSdkInt")
    fun setLocale(context: Context, languageCode: String): Context {
        val locale = when (languageCode) {
            "en" -> Locale("en")
            "ar" -> Locale("ar")
            "bn" -> Locale("bn")
            else -> Locale("en")
        }
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.createConfigurationContext(config)
        } else {
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
            context
        }
    }
} 