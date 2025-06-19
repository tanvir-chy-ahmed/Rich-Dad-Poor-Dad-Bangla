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
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.grow.richdadpoordad.bangla.components.AppTopBar
import com.grow.richdadpoordad.bangla.model.Chapter
import com.grow.richdadpoordad.bangla.model.sampleChapters
import com.grow.richdadpoordad.bangla.ui.theme.ButtonPrimary
import network.chaintech.sdpcomposemultiplatform.sdp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterScreen(
    onChapterClick: (Int) -> Unit,
    onBackClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Main Background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF60438F), // Deep Blue
                            Color(0xFF6E50A2), // Sky Blue
                            Color(0xFF596394)  // Ocean Blue
                        )
                    )
                )
        )

        // Decorative Pattern
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val canvasWidth = size.width

            // Draw diagonal lines pattern
            val lineSpacing = 50f
            val lineColor = Color.White.copy(alpha = 0.05f)

            for (i in 0..(canvasWidth / lineSpacing).toInt() * 2) {
                drawLine(
                    color = lineColor,
                    start = Offset(i * lineSpacing, 0f),
                    end = Offset(0f, i * lineSpacing),
                    strokeWidth = 2f
                )
            }

            // Draw circular gradient overlay
            val radius = size.minDimension * 0.6f
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFE74C3C).copy(alpha = 0.1f),  // Coral Red
                        Color.Transparent
                    ),
                    center = Offset(size.width * 0.8f, size.height * 0.2f),
                    radius = radius
                ),
                center = Offset(size.width * 0.8f, size.height * 0.2f),
                radius = radius
            )
        }

        // Content
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                AppTopBar(
                    title = "Chapters",
                    onBackClick = onBackClick
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.sdp),
                verticalArrangement = Arrangement.spacedBy(16.sdp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(5.sdp))
                }

                items(
                    items = sampleChapters,
                    key = { chapter -> chapter.id }
                ) { chapter ->
                    ChapterCard(
                        chapter = chapter,
                        onClick = { onChapterClick(chapter.id) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.sdp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChapterCard(
    chapter: Chapter,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.sdp)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF34495E).copy(alpha = 0.85f)  // Midnight Blue
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.sdp,
            pressedElevation = 2.sdp
        ),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    ButtonPrimary.copy(alpha = 0.9f),
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.sdp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Chapter ${chapter.id}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(100.sdp)
                )

                Text(
                    text = chapter.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black.copy(alpha = 0.9f),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
} 