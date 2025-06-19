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
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.core.net.toUri
import com.grow.richdadpoordad.bangla.R
import com.grow.richdadpoordad.bangla.components.AppDrawer
import com.grow.richdadpoordad.bangla.components.AppTopBar
import com.grow.richdadpoordad.bangla.ui.theme.ButtonPrimary
import com.grow.richdadpoordad.bangla.ui.theme.CardBackground
import com.grow.richdadpoordad.bangla.ui.theme.MutedWhite
import com.grow.richdadpoordad.bangla.ui.theme.PrimaryContainer
import com.grow.richdadpoordad.bangla.ui.theme.RoyalPurple
import com.grow.richdadpoordad.bangla.ui.theme.SoftYellow
import com.grow.richdadpoordad.bangla.ui.theme.SunshineGold
import com.grow.richdadpoordad.bangla.ui.theme.TextOnSecondary
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    currentLanguage: String,
    onLanguageSelected: (String) -> Unit,
    onStartReading: () -> Unit,
    onNavigateToAbout: () -> Unit,
    onNavigateToPrivacyPolicy: () -> Unit,
    onNavigateToDeveloper: () -> Unit
) {
    val context = LocalContext.current
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                onNavigateToAbout = {
                    scope.launch {
                        drawerState.close()
                    }
                    onNavigateToAbout()
                },
                onNavigateToPrivacyPolicy = {
                    scope.launch {
                        drawerState.close()
                    }
                    onNavigateToPrivacyPolicy()
                },
                onNavigateToDeveloper = {
                    scope.launch {
                        drawerState.close()
                    }
                    onNavigateToDeveloper()
                },
                onNavigateToMoreApps = {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data =
                            "https://play.google.com/store/apps/developer?id=Grow+With+Apps".toUri()
                    }
                    context.startActivity(intent)
                },
                onShareApp = {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_SUBJECT, "Rich Dad Poor Dad - Bangla")
                        putExtra(
                            Intent.EXTRA_TEXT,
                            "Check out Rich Dad Poor Dad in Bangla: https://play.google.com/store/apps/details?id=com.grow.richdadpoordad.bangla"
                        )
                    }
                    context.startActivity(Intent.createChooser(intent, "Share via"))
                },
                onRateApp = {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = "market://details?id=com.grow.richdadpoordad.bangla".toUri()
                    }
                    context.startActivity(intent)
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    title = "",
                    onBackClick = { scope.launch { drawerState.open() } },
                    currentLanguage = currentLanguage,
                    onLanguageSelected = onLanguageSelected,
                    isDrawerNavigation = true
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.fillMaxSize()) {
                // Gradient Background
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    RoyalPurple.copy(alpha = 0.95f),
                                    RoyalPurple.copy(alpha = 0.8f),
                                    PrimaryContainer
                                )
                            )
                        )
                )

                // Decorative shapes
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.sdp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    SunshineGold.copy(alpha = 0.1f),
                                    SunshineGold.copy(alpha = 0.05f),
                                    Color.Transparent
                                )
                            )
                        )
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.sdp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(3.sdp))

                    // Book Cover with shadow
                    Card(
                        modifier = Modifier
                            .size(width = 190.sdp, height = 240.sdp)
                            .clip(RoundedCornerShape(16.sdp)),
                        colors = CardDefaults.cardColors(containerColor = CardBackground),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.sdp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cover1),
                            contentDescription = "Book Cover",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(12.sdp))

                    // Book Title with shadow
                    Text(
                        text = "ধনী বাবা গরিব বাবা",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MutedWhite,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    // Author & Language
                    Text(
                        text = "রবার্ট কিয়োসাকি | বাংলা সংস্করণ",
                        style = MaterialTheme.typography.titleMedium,
                        color = SoftYellow,
                        modifier = Modifier.padding(top = 8.sdp)
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.height(40.sdp))

                    // Feature Buttons Grid
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.sdp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.sdp)
                        ) {
                            FeatureButton(
                                text = "Start Reading",
                                icon = R.drawable.read,
                                modifier = Modifier.weight(1f),
                                onClick = onStartReading
                            )
                            FeatureButton(
                                text = "Rating",
                                icon = R.drawable.rate,
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW).apply {
                                        data = "market://details?id=${context.packageName}".toUri()
                                    }
                                    try {
                                        context.startActivity(intent)
                                    } catch (_: Exception) {
                                        context.startActivity(Intent(Intent.ACTION_VIEW).apply {
                                            data =
                                                "https://play.google.com/store/apps/details?id=${context.packageName}".toUri()
                                        })
                                    }
                                }
                            )

                        }



                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.sdp)
                        ) {
                            FeatureButton(
                                text = "More Apps",
                                icon = R.drawable.app,
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW).apply {
                                        data =
                                            "https://play.google.com/store/apps/developer?id=Grow+With+Apps".toUri()
                                    }
                                    context.startActivity(intent)
                                }
                            )
                            FeatureButton(
                                text = "Share",
                                icon = R.drawable.share,
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    val intent = Intent(Intent.ACTION_SEND).apply {
                                        type = "text/plain"
                                        putExtra(Intent.EXTRA_SUBJECT, "Rich Dad Poor Dad - Bangla")
                                        putExtra(
                                            Intent.EXTRA_TEXT,
                                            "Check out Rich Dad Poor Dad in Bangla: https://play.google.com/store/apps/details?id=com.grow.richdadpoordad.bangla"
                                        )
                                    }
                                    context.startActivity(Intent.createChooser(intent, "Share via"))
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(200.sdp))
                }
            }
        }
    }
}

@Composable
private fun FeatureButton(
    text: String,
    icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(70.sdp)
            .width(40.sdp)
            .clip(RoundedCornerShape(12.sdp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonPrimary.copy(alpha = 0.9f),
            contentColor = TextOnSecondary
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.sdp,
            pressedElevation = 2.sdp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(22.sdp),
                tint = TextOnSecondary
            )
            Spacer(modifier = Modifier.height(4.sdp))
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium,
                color = TextOnSecondary
            )
        }
    }
} 