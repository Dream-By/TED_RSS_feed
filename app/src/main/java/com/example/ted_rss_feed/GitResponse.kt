package com.example.ted_rss_feed

data class GitResponse(val channel: Channel)

data class Channel(val item: List<Item>)