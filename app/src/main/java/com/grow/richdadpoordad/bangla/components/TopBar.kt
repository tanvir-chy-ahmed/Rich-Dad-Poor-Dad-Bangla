package com.grow.richdadpoordad.bangla.components
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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.grow.richdadpoordad.bangla.ui.theme.MutedWhite
import com.grow.richdadpoordad.bangla.ui.theme.RoyalPurple
import com.grow.richdadpoordad.bangla.ui.theme.SunshineGold
import network.chaintech.sdpcomposemultiplatform.sdp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onBackClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    showLanguageMenu: Boolean = true,
    currentLanguage: String = "bn",
    onLanguageSelected: ((String) -> Unit)? = null,
    isDrawerNavigation: Boolean = false
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            RoyalPurple,
                            RoyalPurple.copy(alpha = 0.95f)
                        )
                    )
                )
        ) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MutedWhite,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    if (onBackClick != null) {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = if (isDrawerNavigation) Icons.Default.Menu else Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = if (isDrawerNavigation) "Menu" else "Back",
                                tint = MutedWhite
                            )
                        }
                    }
                },
                actions = {
                    if (showLanguageMenu && onLanguageSelected != null) {
                        LanguageMenu(
                            currentLanguage = currentLanguage,
                            onLanguageSelected = onLanguageSelected,
                            iconTint = MutedWhite
                        )
                    }
                    actions()
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent,
                    navigationIconContentColor = MutedWhite,
                    titleContentColor = MutedWhite,
                    actionIconContentColor = MutedWhite
                )
            )

            // Decorative accent
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.sdp)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                SunshineGold.copy(alpha = 0.0f),
                                SunshineGold.copy(alpha = 0.3f),
                                SunshineGold.copy(alpha = 0.5f),
                                SunshineGold.copy(alpha = 0.3f),
                                SunshineGold.copy(alpha = 0.0f)
                            )
                        )
                    )
            )
        }
    }
} 