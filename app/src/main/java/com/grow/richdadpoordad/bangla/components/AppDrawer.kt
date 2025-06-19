package com.grow.richdadpoordad.bangla.components

/*
**************************************************
*        📱 Mobile App Developer - Tanvir         *
*------------------------------------------------ *
*  🚀 Native & Hybrid App Development Expert      *
*  💼 Tech Stack: Flutter | Jetpack | Firebase    *
*  📧 Email: dev.tanvirchy269@gmail.com                 *
*  🌐 GitHub: https://github.com/tanvir-chy-ahmed *
*  📍 Location: Bangladesh                        *
*                                                 *
*  Need an app? Let’s build something great!      *
**************************************************
*/


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.grow.richdadpoordad.bangla.R
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun AppDrawer(
    onNavigateToAbout: () -> Unit,
    onNavigateToPrivacyPolicy: () -> Unit,
    onNavigateToDeveloper: () -> Unit,
    onNavigateToMoreApps: () -> Unit,
    onShareApp: () -> Unit,
    onRateApp: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.sdp)
            .background(Color(0xFF60438F))
            .padding(vertical = 24.sdp)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.sdp)
        ) {
            Column {
                Text(
                    text = "Rich Dad Poor Dad",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Bangla Edition",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
        }

        Divider(
            color = Color.White.copy(alpha = 0.2f),
            modifier = Modifier.padding(horizontal = 16.sdp, vertical = 8.sdp)
        )

        // Menu Items
        DrawerMenuItem(
            iconResId = R.drawable.info,
            title = "About",
            onClick = onNavigateToAbout
        )

        DrawerMenuItem(
            iconResId = R.drawable.privacy,
            title = "Privacy Policy",
            onClick = onNavigateToPrivacyPolicy
        )

        DrawerMenuItem(
            iconResId = R.drawable.coding,
            title = "Developer",
            onClick = onNavigateToDeveloper
        )

        DrawerMenuItem(
            iconResId = R.drawable.app,
            title = "More Apps",
            onClick = onNavigateToMoreApps
        )

        DrawerMenuItem(
            iconResId = R.drawable.share,
            title = "Share App",
            onClick = onShareApp
        )

        DrawerMenuItem(
            iconResId = R.drawable.rate,
            title = "Rate App",
            onClick = onRateApp
        )

        Spacer(modifier = Modifier.weight(1f))

        // Version info at bottom
        Text(
            text = "Version 1.0.0",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.6f),
            modifier = Modifier.padding(16.sdp)
        )
    }
}

@Composable
private fun DrawerMenuItem(
    iconResId: Int,
    title: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.sdp, vertical = 4.sdp)
            .clip(RoundedCornerShape(8.sdp))
            .clickable(onClick = onClick),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .padding(12.sdp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(24.sdp)
            )
            Spacer(modifier = Modifier.width(16.sdp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
        }
    }
} 