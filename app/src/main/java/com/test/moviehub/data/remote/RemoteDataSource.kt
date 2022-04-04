package com.test.moviehub.data.remote

import androidx.paging.PagingData
import com.test.moviehub.data.model.Root
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface RemoteDataSource {



    suspend fun getPopularMovies(key:String, large_area:String,format:String):
            Response<Root>

    suspend fun getDetails(key:String, id:String,format:String): Response<Root>
}