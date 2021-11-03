package com.khayrul.cryptocurrencyapp.domain.repository

import com.khayrul.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.khayrul.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}