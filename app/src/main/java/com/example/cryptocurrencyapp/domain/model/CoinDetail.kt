package com.example.cryptocurrencyapp.domain.model

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val teamMembers: List<TeamMember>
)