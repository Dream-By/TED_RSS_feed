package com.example.ted_rss_feed

data class ChannelX(
    val description: String,
    val docs: String,
    val image: Image,
    val item: List<Item>,
    val language: String,
    val lastBuildDate: String,
    val link: String,
    val managingEditor: String,
    val pubDate: String,
    val title: String,
    val webMaster: String
)