package com.example.cryptocurrencyapp.data.remote.dto

import com.example.cryptocurrencyapp.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName
import com.example.cryptocurrencyapp.domain.model.TeamMember as ModelTeamMember

data class CoinDetailDto(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("is_active")
    val isActive: Boolean,
    val type: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val description: String,
    val message: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    val whitepaper: Whitepaper,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("last_data_at")
    val lastDataAt: String
)

fun CoinDetailDto.toCoinDetail() = CoinDetail(
    id = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isActive = isActive,
    tags = tags.map { it.name },
    teamMembers = team.map { ModelTeamMember(it.name, it.position) },
)