package com.test.moviehub.domain


import com.test.moviehub.data.model.Root
import retrofit2.Response

interface Repository {

    suspend fun getPopularMovies(key:String, large_area:String,format:String): Response<Root>

    suspend fun getDetails(key:String, id:String,format:String): Response<Root>

}
