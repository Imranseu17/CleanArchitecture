package com.test.restaurant.data.remote

import com.test.restaurant.data.model.Root
import retrofit2.Response


interface RemoteDataSource {



    suspend fun getPopularrestaurants(key:String, large_area:String,format:String):
            Response<Root>

    suspend fun getDetails(key:String, id:String,format:String): Response<Root>
}