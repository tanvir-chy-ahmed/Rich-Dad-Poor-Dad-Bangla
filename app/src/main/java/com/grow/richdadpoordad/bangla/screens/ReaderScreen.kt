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
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.grow.richdadpoordad.bangla.R
import com.grow.richdadpoordad.bangla.components.AppTopBar
import com.grow.richdadpoordad.bangla.model.Chapter
import com.grow.richdadpoordad.bangla.ui.theme.MutedWhite
import com.grow.richdadpoordad.bangla.ui.theme.PrimaryContainer
import com.grow.richdadpoordad.bangla.ui.theme.RoyalPurple
import com.grow.richdadpoordad.bangla.utils.PreferencesManager
import kotlinx.coroutines.launch
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderScreen(
    chapter: Chapter,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    var showSettings by remember { mutableStateOf(false) }

    // Initialize with the last read page for this chapter
    val initialPageIndex = if (preferencesManager.lastReadChapter == chapter.id) {
        chapter.availablePages.indexOf(preferencesManager.lastReadPage)
            .coerceIn(0, chapter.availablePages.size - 1)
    } else {
        0
    }

    val pagerState = rememberPagerState(
        initialPage = initialPageIndex,
        pageCount = { chapter.availablePages.size }
    )

    val coroutineScope = rememberCoroutineScope()
    var currentPageIndex by remember { mutableIntStateOf(initialPageIndex) }
    var currentPage by remember { mutableIntStateOf(chapter.availablePages[initialPageIndex]) }

    // Zoom state for each page
    var scale by remember { mutableFloatStateOf(1f) }
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    // Save last read position
    LaunchedEffect(pagerState.currentPage) {
        currentPageIndex = pagerState.currentPage
        currentPage = chapter.availablePages[currentPageIndex]
        preferencesManager.lastReadChapter = chapter.id
        preferencesManager.lastReadPage = currentPage
        // Reset zoom when page changes
        scale = 1f
        offsetX = 0f
        offsetY = 0f
    }

    // Handle back press
    BackHandler(enabled = scale > 1f) {
        scale = 1f
        offsetX = 0f
        offsetY = 0f
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            RoyalPurple.copy(alpha = 0.95f),
                            RoyalPurple.copy(alpha = 0.8f),
                            PrimaryContainer
                        )
                    )
                )
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                AppTopBar(
                    title = "${chapter.title} - পৃষ্ঠা $currentPage/${chapter.endPage}",
                    onBackClick = onBackClick,
                    actions = {
                        IconButton(onClick = { showSettings = true }) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "সেটিংস",
                                tint = MutedWhite
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Content
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize(),
                    userScrollEnabled = scale <= 1f, // Enable horizontal paging when not zoomed
                    pageSpacing = 8.sdp
                ) { pageIndex ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.sdp),
                            colors = CardDefaults.cardColors(
                                containerColor = MutedWhite.copy(alpha = 0.95f)
                            ),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.sdp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Black)
                            ) {
                                Image(
                                    painter = painterResource(id = getImageResForPage(chapter.availablePages[pageIndex] - 1)),
                                    contentDescription = "পৃষ্ঠা ${chapter.availablePages[pageIndex]}",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .graphicsLayer {
                                            scaleX = scale
                                            scaleY = scale
                                            translationX = offsetX
                                            translationY = offsetY
                                        }
                                        .pointerInput(Unit) {
                                            detectTransformGestures { centroid, pan, gestureZoom, _ ->
                                                val oldScale = scale
                                                scale = (scale * gestureZoom).coerceIn(1f, 3f)

                                                // Adjust the offset to keep the centroid point fixed
                                                val scaleFactor = scale / oldScale
                                                val newOffsetX = offsetX * scaleFactor
                                                val newOffsetY = offsetY * scaleFactor

                                                // Calculate the bounds for panning
                                                val maxX = (size.width * (scale - 1)) / 2
                                                val maxY = (size.height * (scale - 1)) / 2

                                                // Only allow panning when zoomed in
                                                if (scale > 1f) {
                                                    // Update offsets with bounds checking
                                                    offsetX =
                                                        (newOffsetX + pan.x).coerceIn(-maxX, maxX)
                                                    offsetY =
                                                        (newOffsetY + pan.y).coerceIn(-maxY, maxY)
                                                } else {
                                                    // Reset offsets when not zoomed
                                                    offsetX = 0f
                                                    offsetY = 0f
                                                }
                                            }
                                        }
                                )
                            }
                        }
                    }
                }

                // Navigation buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(16.sdp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Previous page button
                    if (currentPageIndex > 0) {
                        FloatingActionButton(
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(currentPageIndex - 1)
                                }
                            },
                            containerColor = RoyalPurple.copy(alpha = 0.8f)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.back),
                                contentDescription = "আগের পৃষ্ঠা",
                                tint = MutedWhite,
                                modifier = Modifier.size(20.sdp)
                            )
                        }
                    }

                    // Page indicator
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = RoyalPurple.copy(alpha = 0.8f)
                        ),
                        modifier = Modifier.padding(horizontal = 8.sdp)
                    ) {
                        Text(
                            text = "$currentPage / ${chapter.endPage}",
                            modifier = Modifier.padding(horizontal = 16.sdp, vertical = 8.sdp),
                            color = MutedWhite,
                            fontSize = 14.ssp,
                            textAlign = TextAlign.Center
                        )
                    }

                    // Next page button
                    if (currentPageIndex < chapter.availablePages.size - 1) {
                        FloatingActionButton(
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(currentPageIndex + 1)
                                }
                            },
                            containerColor = RoyalPurple.copy(alpha = 0.8f)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.next),
                                contentDescription = "পরের পৃষ্ঠা",
                                tint = MutedWhite,
                                modifier = Modifier.size(20.sdp)
                            )
                        }
                    }
                }
            }
        }


        if (showSettings) {
            AlertDialog(
                onDismissRequest = { showSettings = false },
                title = {
                    Text(
                        "পড়ার সেটিংস",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(8.sdp)) {
                        Text("জুম: ${(scale * 100).toInt()}%")
                        Text("• জুম করতে দুই আঙ্গুল ব্যবহার করুন")
                        Text("• জুম করা অবস্থায় এক আঙ্গুল দিয়ে পাতা নাড়াচাড়া করুন")
                        Text("• পাতা পাল্টাতে বাম-ডান স্লাইড করুন")
                        Text("• জুম রিসেট করতে ব্যাক বাটন চাপুন")
                        Text("• জুম না থাকলে পাতা পাল্টানোর জন্য স্লাইড করুন")
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showSettings = false }) {
                        Text("ঠিক আছে")
                    }
                }
            )
        }
    }
}

// Helper to provide image based on page index
@Composable
private fun getImageResForPage(index: Int): Int {
    return when (index + 1) { // Convert to 1-based page numbers
        // ভূমিকা / সূচনা (Introduction)
        1 -> R.drawable.page_1
        2 -> R.drawable.page_2
        3 -> R.drawable.page_3
        7 -> R.drawable.page_4
        8 -> R.drawable.page_5
        9 -> R.drawable.page_6
        10 -> R.drawable.page_7
        11 -> R.drawable.page_9
        12 -> R.drawable.page_10
        13 -> R.drawable.page_11
        14 -> R.drawable.page_12
        15 -> R.drawable.page_13
        16 -> R.drawable.page_14
        17 -> R.drawable.page_15
        18 -> R.drawable.page_16
        19 -> R.drawable.page_17
        20 -> R.drawable.page_18
        21 -> R.drawable.page_19

        // Chapter 1
        22 -> R.drawable.page_20
        23 -> R.drawable.page_21
        24 -> R.drawable.page_22
        25 -> R.drawable.page_23
        26 -> R.drawable.page_24
        27 -> R.drawable.page_25
        28 -> R.drawable.page_26
        29 -> R.drawable.page_27

        // Chapter 2
        in 30..63 -> when (index + 1) {
            30 -> R.drawable.page_28
            31 -> R.drawable.page_29
            32 -> R.drawable.page_30
            33 -> R.drawable.page_31
            34 -> R.drawable.page_32
            35 -> R.drawable.page_33
            36 -> R.drawable.page_34
            37 -> R.drawable.page_35
            38 -> R.drawable.page_36
            39 -> R.drawable.page_37
            40 -> R.drawable.page_38
            41 -> R.drawable.page_39
            42 -> R.drawable.page_40
            43 -> R.drawable.page_41
            44 -> R.drawable.page_42
            45 -> R.drawable.page_43
            46 -> R.drawable.page_44
            47 -> R.drawable.page_45
            48 -> R.drawable.page_46
            49 -> R.drawable.page_47
            50 -> R.drawable.page_48
            51 -> R.drawable.page_49
            52 -> R.drawable.page_50
            53 -> R.drawable.page_51
            54 -> R.drawable.page_52
            55 -> R.drawable.page_53
            56 -> R.drawable.page_54
            57 -> R.drawable.page_55
            58 -> R.drawable.page_56
            59 -> R.drawable.page_57
            60 -> R.drawable.page_58
            61 -> R.drawable.page_59
            62 -> R.drawable.page_60
            63 -> R.drawable.page_61
            else -> R.drawable.page_28
        }

        // Chapter 3
        in 64..91 -> when (index + 1) {
            64 -> R.drawable.page_62
            65 -> R.drawable.page_63
            66 -> R.drawable.page_64
            67 -> R.drawable.page_65
            68 -> R.drawable.page_66
            69 -> R.drawable.page_67
            70 -> R.drawable.page_68
            71 -> R.drawable.page_69
            72 -> R.drawable.page_70
            73 -> R.drawable.page_71
            74 -> R.drawable.page_72
            75 -> R.drawable.page_73
            76 -> R.drawable.page_74
            77 -> R.drawable.page_75
            78 -> R.drawable.page_76
            79 -> R.drawable.page_77
            80 -> R.drawable.page_78
            81 -> R.drawable.page_79
            82 -> R.drawable.page_80
            83 -> R.drawable.page_81
            84 -> R.drawable.page_82
            85 -> R.drawable.page_83
            86 -> R.drawable.page_84
            87 -> R.drawable.page_85
            88 -> R.drawable.page_86
            89 -> R.drawable.page_87
            90 -> R.drawable.page_88
            91 -> R.drawable.page_89
            else -> R.drawable.page_62
        }

        // Chapter 4
        in 92..100 -> when (index + 1) {
            92 -> R.drawable.page_90
            93 -> R.drawable.page_91
            94 -> R.drawable.page_92
            95 -> R.drawable.page_93
            96 -> R.drawable.page_94
            97 -> R.drawable.page_95
            98 -> R.drawable.page_96
            99 -> R.drawable.page_97
            100 -> R.drawable.page_98
            else -> R.drawable.page_90
        }

        // Chapter 5
        in 101..112 -> when (index + 1) {
            101 -> R.drawable.page_99
            102 -> R.drawable.page_100
            103 -> R.drawable.page_101
            104 -> R.drawable.page_102
            105 -> R.drawable.page_103
            106 -> R.drawable.page_104
            107 -> R.drawable.page_105
            108 -> R.drawable.page_106
            109 -> R.drawable.page_107
            110 -> R.drawable.page_108
            111 -> R.drawable.page_109
            112 -> R.drawable.page_110
            else -> R.drawable.page_99
        }

        // Chapter 6
        in 113..133 -> when (index + 1) {
            113 -> R.drawable.page_111
            114 -> R.drawable.page_112
            115 -> R.drawable.page_113
            116 -> R.drawable.page_114
            117 -> R.drawable.page_115
            118 -> R.drawable.page_116
            119 -> R.drawable.page_117
            120 -> R.drawable.page_118
            121 -> R.drawable.page_119
            122 -> R.drawable.page_120
            123 -> R.drawable.page_121
            124 -> R.drawable.page_122
            125 -> R.drawable.page_123
            126 -> R.drawable.page_124
            127 -> R.drawable.page_125
            128 -> R.drawable.page_126
            129 -> R.drawable.page_127
            130 -> R.drawable.page_128
            131 -> R.drawable.page_129
            132 -> R.drawable.page_130
            133 -> R.drawable.page_131
            else -> R.drawable.page_111
        }

        // Chapter 7
        in 134..147 -> when (index + 1) {
            134 -> R.drawable.page_132
            135 -> R.drawable.page_133
            136 -> R.drawable.page_134
            137 -> R.drawable.page_135
            138 -> R.drawable.page_136
            139 -> R.drawable.page_137
            140 -> R.drawable.page_138
            141 -> R.drawable.page_139
            142 -> R.drawable.page_140
            143 -> R.drawable.page_141
            144 -> R.drawable.page_142
            145 -> R.drawable.page_143
            146 -> R.drawable.page_144
            147 -> R.drawable.page_145
            else -> R.drawable.page_132
        }

        // Chapter 8
        in 148..164 -> when (index + 1) {
            148 -> R.drawable.page_146
            149 -> R.drawable.page_147
            150 -> R.drawable.page_148
            151 -> R.drawable.page_149
            152 -> R.drawable.page_150
            153 -> R.drawable.page_151
            154 -> R.drawable.page_152
            155 -> R.drawable.page_153
            156 -> R.drawable.page_154
            157 -> R.drawable.page_155
            158 -> R.drawable.page_156
            159 -> R.drawable.page_157
            160 -> R.drawable.page_158
            161 -> R.drawable.page_159
            162 -> R.drawable.page_160
            163 -> R.drawable.page_161
            164 -> R.drawable.page_162
            else -> R.drawable.page_146
        }

        // Chapter 9
        in 165..196 -> when (index + 1) {
            165 -> R.drawable.page_163
            166 -> R.drawable.page_164
            167 -> R.drawable.page_165
            168 -> R.drawable.page_166
            169 -> R.drawable.page_167
            170 -> R.drawable.page_168
            171 -> R.drawable.page_169
            172 -> R.drawable.page_170
            173 -> R.drawable.page_171
            174 -> R.drawable.page_172
            175 -> R.drawable.page_173
            176 -> R.drawable.page_174
            177 -> R.drawable.page_175
            178 -> R.drawable.page_176
            179 -> R.drawable.page_177
            180 -> R.drawable.page_178
            181 -> R.drawable.page_179
            182 -> R.drawable.page_180
            183 -> R.drawable.page_181
            184 -> R.drawable.page_182
            185 -> R.drawable.page_183
            186 -> R.drawable.page_184
            187 -> R.drawable.page_185
            188 -> R.drawable.page_186
            189 -> R.drawable.page_187
            190 -> R.drawable.page_188
            191 -> R.drawable.page_189
            192 -> R.drawable.page_190
            193 -> R.drawable.page_191
            194 -> R.drawable.page_192
            195 -> R.drawable.page_193
            196 -> R.drawable.page_194
            else -> R.drawable.page_163
        }

        // Chapter 10
        in 188..197 -> when (index + 1) {
            188 -> R.drawable.page_186
            189 -> R.drawable.page_187
            190 -> R.drawable.page_188
            191 -> R.drawable.page_189
            192 -> R.drawable.page_190
            193 -> R.drawable.page_191
            else -> R.drawable.page_186
        }

        // Final Chapter (বিশেষ সংযোজন)
        in 199..210 -> when (index + 1) {
            199 -> R.drawable.page_192
            200 -> R.drawable.page_193
            201 -> R.drawable.page_194
            202 -> R.drawable.page_195
            203 -> R.drawable.page_196
            204 -> R.drawable.page_197
            205 -> R.drawable.page_198
            206 -> R.drawable.page_199
            207 -> R.drawable.page_200
            208 -> R.drawable.page_201
            else -> R.drawable.page_192
        }

        else -> R.drawable.page_1 // Default fallback
    }
}
