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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.grow.richdadpoordad.bangla.R
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
fun WorkInProgressScreen(
    selectedLanguage: String,
    onBackToLanguageSelection: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.sdp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.add), // You might want to replace this with a more appropriate image
            contentDescription = "Work in Progress",
            modifier = Modifier
                .size(120.sdp)
                .padding(bottom = 24.sdp)
        )

        Text(
            text = "Coming Soon!",
            fontSize = 32.ssp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.sdp)
        )

        Text(
            text = "We're working hard to bring you Rich Dad Poor Dad in ${
                selectedLanguage.removeSuffix(
                    "_wip"
                ).capitalize()
            }.\n\nStay tuned for updates!",
            fontSize = 18.ssp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.sdp)
        )

        Button(
            onClick = onBackToLanguageSelection,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Back to Language Selection",
                modifier = Modifier.padding(vertical = 8.sdp)
            )
        }
    }
} 