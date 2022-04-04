package com.test.moviehub.domain


import com.test.moviehub.data.model.Root
import retrofit2.Response
import javax.inject.Inject

class GetPopularMovies @Inject constructor(
    private val repository: Repository
) {
    suspend fun call(): Response<Root> =
        repository.getPopularMovies("f5c06c8896e2d2d4","Z011","json")
}