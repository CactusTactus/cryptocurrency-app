package com.example.cryptocurrencyapp.presentation.coinlist.components

import com.example.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val errorMessage: String = ""
)
