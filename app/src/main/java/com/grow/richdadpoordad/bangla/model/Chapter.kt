package com.grow.richdadpoordad.bangla.model

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
data class Chapter(
    val id: Int,
    val title: String,
    val content: String,
    val totalPages: Int,
    val readTimeMinutes: Int,
    val startPage: Int,
    val endPage: Int,
    val availablePages: List<Int>,
    val currentPage: Int = 1,
    val isBookmarked: Boolean = false
)

// Sample chapters data with available pages
val sampleChapters = listOf(
    Chapter(
        id = 0,
        title = "ভূমিকা / সূচনা",
        content = "এর বিশেষ প্রয়োজন আছে",
        totalPages = 21,
        readTimeMinutes = 30,
        startPage = 1,
        endPage = 21,
        availablePages = listOf(1, 2, 3, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)
    ),
    Chapter(
        id = 1,
        title = "১ম অধ্যায় - ধনবান বাবা, গরিব বাবা",
        content = "ধনবান বাবা, গরিব বাবা",
        totalPages = 8,
        readTimeMinutes = 15,
        startPage = 22,
        endPage = 29,
        availablePages = listOf(22, 23, 24, 25, 26, 27, 28, 29)
    ),
    Chapter(
        id = 2,
        title = "২য় অধ্যায় - প্রথম শিক্ষা",
        content = "ধনীরা অর্থের জন্য কাজ করে না",
        totalPages = 34,
        readTimeMinutes = 45,
        startPage = 30,
        endPage = 63,
        availablePages = (30..63).toList()
    ),
    Chapter(
        id = 3,
        title = "৩য় অধ্যায় - দ্বিতীয় শিক্ষা",
        content = "অর্থনৈতিক জ্ঞানের শিক্ষা কেন দেওয়া উচিত?",
        totalPages = 28,
        readTimeMinutes = 35,
        startPage = 64,
        endPage = 91,
        availablePages = (64..91).toList()
    ),
    Chapter(
        id = 4,
        title = "৪র্থ অধ্যায় - তৃতীয় শিক্ষা",
        content = "শুধু নিজের কাজে মনোযোগ দিন",
        totalPages = 9,
        readTimeMinutes = 15,
        startPage = 92,
        endPage = 100,
        availablePages = (92..100).toList()
    ),
    Chapter(
        id = 5,
        title = "৫ম অধ্যায় - চতুর্থ শিক্ষা",
        content = "কর এবং কর্পোরেশনের ক্ষমতা",
        totalPages = 12,
        readTimeMinutes = 20,
        startPage = 101,
        endPage = 112,
        availablePages = (101..112).toList()
    ),
    Chapter(
        id = 6,
        title = "৬ষ্ঠ অধ্যায় - পঞ্চম শিক্ষা",
        content = "ধনীরা অর্থ তৈরি করে",
        totalPages = 21,
        readTimeMinutes = 30,
        startPage = 113,
        endPage = 133,
        availablePages = (113..133).toList()
    ),
    Chapter(
        id = 7,
        title = "৭ম অধ্যায় - ষষ্ঠ শিক্ষা",
        content = "শেখার জন্য কাজ করুন, অর্থের জন্য নয়",
        totalPages = 14,
        readTimeMinutes = 20,
        startPage = 134,
        endPage = 147,
        availablePages = (134..147).toList()
    ),
    Chapter(
        id = 8,
        title = "৮ম অধ্যায় - বাধা অতিক্রম করা",
        content = "বাধা অতিক্রম করা",
        totalPages = 17,
        readTimeMinutes = 25,
        startPage = 148,
        endPage = 164,
        availablePages = (148..164).toList()
    ),
    Chapter(
        id = 9,
        title = "৯ম অধ্যায় - শুরু করা",
        content = "শুরু করা",
        totalPages = 20,
        readTimeMinutes = 45,
        startPage = 165,
        endPage = 185,
        availablePages = (165..185).toList()
    ),
    Chapter(
        id = 10,
        title = "১০ম অধ্যায় - উপসংহার",
        content = "আরও কিছু চাই কি? কিছু করণীয়",
        totalPages = 6,
        readTimeMinutes = 10,
        startPage = 188,
        endPage = 193,
        availablePages = (188..193).toList()
    ),
    Chapter(
        id = 11,
        title = "বিশেষ সংযোজন",
        content = "উপসংহার",
        totalPages = 10,
        readTimeMinutes = 15,
        startPage = 199,
        endPage = 208,
        availablePages = (199..208).toList()
    )
) 