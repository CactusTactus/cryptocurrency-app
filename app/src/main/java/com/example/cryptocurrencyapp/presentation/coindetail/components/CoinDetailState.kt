package com.example.cryptocurrencyapp.presentation.coindetail.components

import com.example.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val errorMessage: String = ""
)
