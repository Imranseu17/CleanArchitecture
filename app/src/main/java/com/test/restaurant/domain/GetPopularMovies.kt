package com.test.restaurant.domain


import com.test.restaurant.data.model.Root
import retrofit2.Response
import javax.inject.Inject

class GetPopularrestaurants @Inject constructor(
    private val repository: Repository
) {
    suspend fun call(): Response<Root> =
        repository.getPopularrestaurants("f5c06c8896e2d2d4","Z011","json")
}