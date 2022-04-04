package com.test.restaurant.domain.base

import com.example.restaurant.utils.Resource
import com.test.restaurant.data.model.Shop
import com.test.restaurant.domain.exceptions.ErrorModel

interface UseCaseCallback {

    fun onSuccess(result: Resource<Shop>)

    fun onError(errorModel: ErrorModel?)
}