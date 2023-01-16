package com.xuannie.hdbcarpark.ui.data.database

import com.xuannie.hdbcarpark.ui.network.CarParkAvailability
import com.xuannie.hdbcarpark.ui.network.UraApiService

interface URADataRepository {
    // Carpark Available Lots
    suspend fun getAvailableParkingLots(): CarParkAvailability

}

class DefaultURADataRepository(
    private val uraApiService: UraApiService
): URADataRepository {
    override suspend fun getAvailableParkingLots(): CarParkAvailability {
        return uraApiService.getAvailableParkingLots()
    }

}