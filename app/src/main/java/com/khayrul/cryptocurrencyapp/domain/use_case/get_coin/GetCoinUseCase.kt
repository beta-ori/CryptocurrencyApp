package com.khayrul.cryptocurrencyapp.domain.use_case.get_coin

import com.khayrul.cryptocurrencyapp.common.Resource
import com.khayrul.cryptocurrencyapp.data.remote.dto.toCoin
import com.khayrul.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.khayrul.cryptocurrencyapp.domain.model.CoinDetail
import com.khayrul.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
             emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Something went wrong"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach the sever. Check your internet connection"))
        }
    }
}