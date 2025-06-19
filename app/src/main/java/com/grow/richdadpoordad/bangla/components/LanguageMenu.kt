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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.grow.richdadpoordad.bangla.R
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun LanguageMenu(
    currentLanguage: String,
    onLanguageSelected: (String) -> Unit,
    iconTint: Color = Color.White
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(
                painter = painterResource(R.drawable.language),
                modifier = Modifier.size(30.sdp),
                contentDescription = "Change Language",
                tint = iconTint
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            LanguageMenuItem(
                language = "বাংলা",
                flagResId = R.drawable.bangladesh_flag,
                languageCode = "bn",
                currentLanguage = currentLanguage,
                onClick = {
                    onLanguageSelected("bn")
                    expanded = false
                }
            )
            LanguageMenuItem(
                language = "English",
                flagResId = R.drawable.uk_flag,
                languageCode = "en",
                currentLanguage = currentLanguage,
                onClick = {
                    onLanguageSelected("en_wip")
                    expanded = false
                }
            )
            LanguageMenuItem(
                language = "हिंदी",
                flagResId = R.drawable.india_flag,
                languageCode = "hi",
                currentLanguage = currentLanguage,
                onClick = {
                    onLanguageSelected("hi_wip")
                    expanded = false
                }
            )
            LanguageMenuItem(
                language = "العربية",
                flagResId = R.drawable.arabic_flag,
                languageCode = "ar",
                currentLanguage = currentLanguage,
                onClick = {
                    onLanguageSelected("ar_wip")
                    expanded = false
                }
            )
        }
    }
}

@Composable
private fun LanguageMenuItem(
    language: String,
    flagResId: Int,
    languageCode: String,
    currentLanguage: String,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        text = { Text(language) },
        onClick = onClick,
        leadingIcon = {
            Icon(
                painter = painterResource(id = flagResId), modifier = Modifier.size(30.sdp),
                contentDescription = null,
                tint = Color.Unspecified
            )
        },
        trailingIcon = if (currentLanguage == languageCode) {
            {
                Icon(
                    painter = painterResource(id = R.drawable.check),
                    modifier = Modifier.size(18.sdp),
                    contentDescription = null
                )
            }
        } else null
    )
} 