package com.test.restaurant.data.remote


import com.test.restaurant.data.model.Root
import com.test.restaurant.data.remote.connection.RestaurantService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: RestaurantService) :
    RemoteDataSource {


    override suspend fun getPopularrestaurants(key:String, large_area:String,format:String):
            Response<Root> {
        return  service.getPopularrestaurants(key,large_area,format)
    }

    override suspend fun getDetails(key:String, id:String,format:String): Response<Root>  {
        return service.getDetails(key, id, format)
    }

}