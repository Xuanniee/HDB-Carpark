package com.xuannie.hdbcarpark.ui.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * URA Carpark APIs
 */
@Serializable
data class CarParkAvailability(
    @SerialName(value = "Status")
    val status: String = "No API Call Yet",

    @SerialName(value = "Message")
    val message: String = "NA",

    @SerialName(value = "Result")
    val carparkList: List<Carparks> = listOf(Carparks()),
)

@Serializable
data class Carparks(
    val carparkNo: String = "No Carpark Found",

    val geometries: List<CarparkCoordinates> = listOf(CarparkCoordinates()),

    val lotsAvailable: String = "NA",

    val lotType: String = "NA",
)

@Serializable
data class CarparkCoordinates(
    val coordinates: String = "NA"
)




