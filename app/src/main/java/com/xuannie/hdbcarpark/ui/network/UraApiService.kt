package com.xuannie.hdbcarpark.ui.network

import com.xuannie.hdbcarpark.TOKEN_16_JAN
import com.xuannie.hdbcarpark.URA_SECRET_ACCESS_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UraApiService {
    /**
     *  Function to get JSON Objects from URI by specifying Type of Request and Endpoint like "/photos" a URL of sorts
     */
    // 1. Returns Car Park Available Lots
    @Headers(
        "AccessKey: $URA_SECRET_ACCESS_KEY",
        "Token: $TOKEN_16_JAN"
    )
    @GET("invokeUraDS?service=Car_Park_Availability")
    suspend fun getAvailableParkingLots(
    ): CarParkAvailability



    /*
    // 2. Returns Bus Timings for Bus Service
    @Headers(
        "accept: application/json",
        "AccountKey: $LTA_API_SECRET_KEY"
    )
    @GET("BusArrivalv2")
    suspend fun getTimingsOfBusService(
        @Query("ServiceNo") ServiceNo: String
    ): SingaporeBus

    // 3. Returns Bus Timings for Bus Stop and Bus Service
    @Headers(
        "accept: application/json",
        "AccountKey: $LTA_API_SECRET_KEY"
    )
    @GET("BusArrivalv2")
    suspend fun getTimingsOfBusStopAndBusService(
        @Query("BusStopCode") BusStopCode: String,
        @Query("ServiceNo") ServiceNo: String
    ): SingaporeBus
     */
}