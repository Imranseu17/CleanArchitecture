package com.test.moviehub.data


import com.test.moviehub.data.model.Root
import com.test.moviehub.data.remote.RemoteDataSource
import com.test.moviehub.domain.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {


    override suspend fun getPopularMovies(key:String, large_area:String,format:String): Response<Root> {
        return remoteDataSource.getPopularMovies(key, large_area, format)
    }

    override suspend fun getDetails(key: String, id: String, format: String): Response<Root> {
       return remoteDataSource.getDetails(key,id,format)
    }


}