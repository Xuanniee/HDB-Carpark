package com.xuannie.hdbcarpark.ui.data.database

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.xuannie.hdbcarpark.ui.network.UraApiService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface HdbAppContainer {
    // URA Token to access their API
    val uraDataRepository: URADataRepository
}

class DefaultAppContainer(
    private val context: Context
): HdbAppContainer {
    // URL does not include query parameters like ServiceNo and BusStopCode
    private val BASE_URL =
        "https://www.ura.gov.sg/uraDataService/"

    // For AppViewModel
    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: UraApiService by lazy {
        retrofit.create(UraApiService::class.java)
    }

    // Override the Property in the Interface
    override val uraDataRepository by lazy {
        DefaultURADataRepository(retrofitService)
    }

//    override val favouriteBusStopRepository: FavouriteBusStopRepository by lazy {
//        DefaultFavouriteBusRepository(
//            favouriteBusStopDao = FavouritesBusDatabase.getDatabase(context).favouriteBusDao(),
//            busApiService = retrofitService
//        )
//    }
}