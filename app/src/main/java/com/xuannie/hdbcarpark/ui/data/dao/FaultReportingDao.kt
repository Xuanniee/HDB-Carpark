package com.xuannie.hdbcarpark.ui.data.dao

import androidx.room.*

@Dao
interface FaultReportingDao {
    /**
     * Allows User to add any BusStop into their Favourites List.
     * Suspend to allow it to run on a separate thread as database operations take a long time to perform
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFaultReported ()

    /**
     * Allows User to Edit their favourite Bus Stops such as renaming the Bus Stop
     */
    @Update
    suspend fun updateBusStop()

    /**
     * Allows Users to remove any BusStop from their Favourites List
     */
    @Delete
    suspend fun deleteBusStop()

    /**
     * Allows User to retrieve all the BusStops available in their favourites
     * Returning Flow allows us to be notified whenever data in the database is altered and causing a background thread to be used
     * NOTE: Use Coroutine Flow and Not other Flow
     */
//    @Query(value = "SELECT * FROM `User's Favourites List` ORDER BY id ASC")
//    fun retrieveAllFavouriteBusStops(): Flow<List<FavouriteBusStop>>
//
//    @Query(value = "SELECT * FROM `User's Favourites List` WHERE id = :id") // Variable Substitution

}