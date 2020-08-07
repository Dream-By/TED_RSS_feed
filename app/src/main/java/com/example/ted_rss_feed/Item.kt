package com.example.ted_rss_feed

data class Item(
    val description: String,
    val duration: Duration,
    val enclosure: Enclosure,
    val group: Group,
    val guid: Guid,
    val image: ImageX,
    val link: String,
    val pubDate: String,
    val title: String
)