package com.alejandro.horoscapp.data

import android.util.Log
import com.alejandro.horoscapp.data.network.HoroscopeApiService
import com.alejandro.horoscapp.domain.Repository
import com.alejandro.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign)}
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("aris", "ha ocurrido un error ${it.message}") }

        return null
    }
}