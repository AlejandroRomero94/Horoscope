package com.alejandro.horoscapp.data.network.response

import com.alejandro.horoscapp.motherobject.MotherObject
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionResponseTest {
    @Test
    fun `to Domain should return a correct PredictionModel`() {

        //Given
        val horoscopeResponse =
            MotherObject.anyResponse

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}