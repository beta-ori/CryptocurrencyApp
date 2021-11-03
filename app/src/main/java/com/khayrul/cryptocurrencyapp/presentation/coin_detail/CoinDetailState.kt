package com.khayrul.cryptocurrencyapp.presentation.coin_detail

import com.khayrul.cryptocurrencyapp.domain.model.Coin
import com.khayrul.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)