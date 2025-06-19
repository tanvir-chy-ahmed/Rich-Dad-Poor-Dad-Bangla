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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.grow.richdadpoordad.bangla.components.AppTopBar
import network.chaintech.sdpcomposemultiplatform.sdp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeveloperScreen(
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

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
                    title = "Developer",
                    onBackClick = onBackClick
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.sdp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.9f)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.sdp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Developer Profile Image
                        Image(
                            painter = painterResource(R.drawable.coding),
                            contentDescription = "Developer Profile",
                            modifier = Modifier
                                .size(120.sdp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(16.sdp))

                        Text(
                            text = "Tanvir ahmed chowdhury",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Text(
                            text = "Software Developer",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(24.sdp))

                        Text(
                            text = "Fuelled by code and driven by creativity, I turn ideas into powerful digital experiences.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(24.sdp))

                        // Social Links
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            SocialButton(
                                iconResId = R.drawable.gmail,
                                label = "Email",
                                onClick = {
                                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                                        data = "mailto:tanvirchy269@gmail.com".toUri()
                                    }
                                    context.startActivity(
                                        Intent.createChooser(
                                            intent,
                                            "Send email"
                                        )
                                    )
                                }
                            )

                            SocialButton(
                                iconResId = R.drawable.whatsapp,
                                label = "Whatsapp",
                                onClick = {
                                    val intent = Intent(
                                        Intent.ACTION_VIEW,
                                        "https://wa.me/8801914627085?text=Assalamu%20Alaikum%2C%20Brother".toUri()
                                    )
                                    context.startActivity(intent)
                                }
                            )

                            SocialButton(
                                iconResId = R.drawable.linkedin,
                                label = "LinkedIn",
                                onClick = {
                                    val intent = Intent(
                                        Intent.ACTION_VIEW,
                                        "https://www.linkedin.com/in/tanvir-ahmed-chy-126191367/".toUri()
                                    )
                                    context.startActivity(intent)
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(24.sdp))


                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                    data =
                                        "https://play.google.com/store/apps/developer?id=YourDeveloperID".toUri()
                                }
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF60438F)
                            )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.app),
                                contentDescription = "More Apps",
                                modifier = Modifier.size(20.sdp)
                            )
                            Spacer(modifier = Modifier.width(8.sdp))
                            Text("View More Apps")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SocialButton(
    iconResId: Int,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(48.sdp)
                .clip(CircleShape)
                .background(Color(0xFF60438F))
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                modifier = Modifier.size(26.sdp),
                contentDescription = label,
                tint = Color.White
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.sdp)
        )
    }
}



