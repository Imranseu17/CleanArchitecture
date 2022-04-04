package com.test.restaurant.data.remote


import com.test.restaurant.data.model.Root
import com.test.restaurant.data.remote.connection.MService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: MService) :
    RemoteDataSource {


    override suspend fun getPopularMovies(key:String, large_area:String,format:String):
            Response<Root> {
        return  service.getPopularMovies(key,large_area,format)
    }

    override suspend fun getDetails(key:String, id:String,format:String): Response<Root>  {
        return service.getDetails(key, id, format)
    }

}