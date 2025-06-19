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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.grow.richdadpoordad.bangla.components.AppTopBar
import network.chaintech.sdpcomposemultiplatform.sdp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(
    onBackClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF60438F),
                            Color(0xFF6E50A2),
                            Color(0xFF596394)
                        )
                    )
                )
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                AppTopBar(
                    title = "Privacy Policy",
                    onBackClick = onBackClick
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.sdp)
                    .verticalScroll(rememberScrollState())
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.9f)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.sdp)
                    ) {
                        Text(
                            text = "Privacy Policy",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(16.sdp))

                        Text(
                            text = "Last updated: January 2024",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(24.sdp))

                        PolicySection(
                            title = "Information Collection",
                            content = "We do not collect any personal information. The app works completely offline and does not require any user registration or data submission."
                        )

                        PolicySection(
                            title = "App Permissions",
                            content = "The app only requires storage permission to save your bookmarks and reading preferences locally on your device."
                        )

                        PolicySection(
                            title = "Data Storage",
                            content = "All data (bookmarks, reading progress, and settings) is stored locally on your device and is not transmitted to any external servers."
                        )

                        PolicySection(
                            title = "Third-Party Services",
                            content = "We use Google Play Services for app distribution and updates. Please refer to Google's privacy policy for information about their data practices."
                        )

                        PolicySection(
                            title = "Children's Privacy",
                            content = "Our app does not specifically target children under 13. We do not knowingly collect personal information from children under 13."
                        )

                        PolicySection(
                            title = "Changes to Policy",
                            content = "We may update our Privacy Policy from time to time. We will notify you of any changes by posting the new Privacy Policy on this screen."
                        )

                        Spacer(modifier = Modifier.height(24.sdp))

                        Text(
                            text = "Contact Us",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(8.sdp))

                        Text(
                            text = "If you have any questions about this Privacy Policy, please contact with me at:\ntanvirchy269@gmail.com",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PolicySection(
    title: String,
    content: String
) {
    Column(
        modifier = Modifier.padding(bottom = 24.sdp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.sdp))

        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
} 