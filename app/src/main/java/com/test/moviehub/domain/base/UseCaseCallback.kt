package com.test.moviehub.domain.base

import com.example.restaurant.utils.Resource
import com.test.moviehub.data.model.Shop
import com.test.moviehub.domain.exceptions.ErrorModel

interface UseCaseCallback {

    fun onSuccess(result: Resource<Shop>)

    fun onError(errorModel: ErrorModel?)
}