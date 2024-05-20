package com.alejandro.horoscapp.motherobject

import com.alejandro.horoscapp.data.network.response.PredictionResponse
import com.alejandro.horoscapp.domain.model.HoroscopeInfo.*

object MotherObject {

    val anyResponse=PredictionResponse("date", "prediction", "taurus")

    val   horoscopeInfoList= listOf(
        Aries,
    Taurus,
    Gemini,
    Cancer,
    Leo,
    Virgo,
    Libra,
    Scorpio,
    Sagittarius,
    Capricorn,
    Aquarius,
    Pisces
    )
}