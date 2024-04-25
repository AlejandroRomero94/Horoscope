package com.alejandro.horoscapp.domain

import com.alejandro.horoscapp.data.network.response.PredictionResponse
import com.alejandro.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}
