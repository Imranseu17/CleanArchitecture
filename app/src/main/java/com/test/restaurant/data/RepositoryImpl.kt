package com.test.restaurant.data


import com.test.restaurant.data.model.Root
import com.test.restaurant.data.remote.RemoteDataSource
import com.test.restaurant.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {


    override suspend fun getPopularrestaurants(key:String, large_area:String,format:String):
            Response<Root> {
        return remoteDataSource.getPopularrestaurants(key, large_area, format)
    }

    override suspend fun getDetails(key: String, id: String, format: String):
            Response<Root> {
       return remoteDataSource.getDetails(key,id,format)
    }


}