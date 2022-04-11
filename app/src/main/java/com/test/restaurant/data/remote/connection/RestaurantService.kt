package com.test.restaurant.data.remote.connection

import com.test.restaurant.data.model.Root
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantService {

    /**
     * Restaurant List.
     * @param key, large_area , format to perform.
     */
    @GET("v1")
    suspend fun getPopularrestaurants(
        @Query("key") key:String,
        @Query("large_area") large_area:String,
        @Query("format")format:String
    ): Response<Root>

    /**
     * get restaurant details.
     * @param key, id, format to perform.
     */
    @GET("v1")
    suspend fun getDetails(
        @Query("key") key:String,
        @Query("id") id:String,
        @Query("format")format:String
    ): Response<Root>

}