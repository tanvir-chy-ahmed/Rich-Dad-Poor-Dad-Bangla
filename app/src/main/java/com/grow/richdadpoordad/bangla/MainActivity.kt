package com.grow.richdadpoordad.bangla
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
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.grow.richdadpoordad.bangla.model.sampleChapters
import com.grow.richdadpoordad.bangla.screens.AboutScreen
import com.grow.richdadpoordad.bangla.screens.ChapterScreen
import com.grow.richdadpoordad.bangla.screens.DeveloperScreen
import com.grow.richdadpoordad.bangla.screens.LanguageScreen
import com.grow.richdadpoordad.bangla.screens.MainScreen
import com.grow.richdadpoordad.bangla.screens.PrivacyPolicyScreen
import com.grow.richdadpoordad.bangla.screens.ReaderScreen
import com.grow.richdadpoordad.bangla.screens.WorkInProgressScreen
import com.grow.richdadpoordad.bangla.ui.theme.RichDadPoorDadTheme
import com.grow.richdadpoordad.bangla.utils.LocaleHelper
import com.grow.richdadpoordad.bangla.utils.PreferencesManager

class MainActivity : ComponentActivity() {
    private lateinit var preferencesManager: PreferencesManager

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferencesManager = PreferencesManager(this)

        // Lock screen orientation to portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            RichDadPoorDadTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }

    override fun attachBaseContext(newBase: android.content.Context) {
        preferencesManager = PreferencesManager(newBase)
        val context = LocaleHelper.setLocale(newBase, preferencesManager.selectedLanguage)
        super.attachBaseContext(context)
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }

    NavHost(
        navController = navController,
        startDestination = if (preferencesManager.isFirstLaunch) "language" else "main"
    ) {
        composable("language") {
            LanguageScreen(
                onLanguageSelected = { language ->
                    if (language.endsWith("_wip")) {
                        navController.navigate("work_in_progress/$language")
                    } else {
                        preferencesManager.selectedLanguage = language
                        navController.navigate("main") {
                            popUpTo("language") { inclusive = true }
                        }
                    }
                }
            )
        }
        composable(
            route = "work_in_progress/{language}",
            arguments = listOf(
                navArgument("language") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            WorkInProgressScreen(
                selectedLanguage = backStackEntry.arguments?.getString("language") ?: "",
                onBackToLanguageSelection = {
                    navController.popBackStack()
                }
            )
        }
        composable("main") {
            MainScreen(
                currentLanguage = preferencesManager.selectedLanguage,
                onLanguageSelected = { language ->
                    if (language.endsWith("_wip")) {
                        navController.navigate("work_in_progress/$language")
                    } else {
                        preferencesManager.selectedLanguage = language
                    }
                },
                onStartReading = {
                    navController.navigate("chapters")
                },
                onNavigateToAbout = {
                    navController.navigate("about")
                },
                onNavigateToPrivacyPolicy = {
                    navController.navigate("privacy_policy")
                },
                onNavigateToDeveloper = {
                    navController.navigate("developer")
                }
            )
        }
        composable("chapters") {
            ChapterScreen(
                onChapterClick = { chapterId ->
                    navController.navigate("reader/$chapterId")
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable(
            route = "reader/{chapterId}",
            arguments = listOf(
                navArgument("chapterId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val chapterId = backStackEntry.arguments?.getInt("chapterId") ?: 1
            val chapter = sampleChapters.find { it.id == chapterId }
                ?: sampleChapters.first()

            ReaderScreen(
                chapter = chapter,
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }

        composable("about") {
            AboutScreen(
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable("privacy_policy") {
            PrivacyPolicyScreen(
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable("developer") {
            DeveloperScreen(
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}