package com.grow.richdadpoordad.bangla.screens
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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.grow.richdadpoordad.bangla.R
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageScreen(
    onLanguageSelected: (String) -> Unit
) {
    var selectedLanguage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.sdp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Language",
                fontSize = 32.ssp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.sdp)
            )

            Text(
                text = "🌐 Choose a language\nto continue.",
                fontSize = 18.ssp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 48.sdp)
            )

            Text(
                text = "Choose Language",
                fontSize = 18.ssp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.sdp),
                color = Color.DarkGray
            )

            // Language Grid
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.sdp)
            ) {
                // First Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LanguageOption(
                        language = "English",
                        flagResId = R.drawable.uk_flag,
                        isSelected = selectedLanguage == "English",
                        onClick = {
                            selectedLanguage = "English"
                        },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.sdp))
                    LanguageOption(
                        language = "Hindi",
                        flagResId = R.drawable.india_flag,
                        isSelected = selectedLanguage == "Hindi",
                        onClick = {
                            selectedLanguage = "Hindi"
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                // Second Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LanguageOption(
                        language = "বাংলা",
                        flagResId = R.drawable.bangladesh_flag,
                        isSelected = selectedLanguage == "Bangla",
                        onClick = {
                            selectedLanguage = "Bangla"
                        },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(16.sdp))
                    LanguageOption(
                        language = "العربية",
                        flagResId = R.drawable.arabic_flag,
                        isSelected = selectedLanguage == "Arabic",
                        onClick = {
                            selectedLanguage = "Arabic"
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (selectedLanguage.isNotEmpty()) {
                        when (selectedLanguage) {
                            "English" -> onLanguageSelected("en")
                            "Arabic" -> onLanguageSelected("ar")
                            "বাংলা" -> onLanguageSelected("bn")
                            else -> onLanguageSelected("${selectedLanguage.lowercase()}_wip")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.sdp),
                shape = RoundedCornerShape(8.sdp)
            ) {
                Text(
                    text = "SAVE",
                    modifier = Modifier.padding(vertical = 8.sdp)
                )
            }
        }
    }
}

@Composable
fun LanguageOption(
    language: String,
    flagResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(140.sdp)
            .border(
                width = if (isSelected) 2.sdp else 1.sdp,
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                shape = RoundedCornerShape(12.sdp)
            )
            .background(Color.White, RoundedCornerShape(12.sdp))
            .clickable(onClick = onClick)
            .padding(16.sdp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = flagResId),
                contentDescription = "$language flag",
                modifier = Modifier
                    .size(60.sdp)
                    .padding(bottom = 8.sdp)
            )
            Text(
                text = language,
                fontSize = 16.ssp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}