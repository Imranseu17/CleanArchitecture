package com.test.restaurant.domain.base

import com.example.restaurant.utils.Resource
import com.test.restaurant.data.model.Root
import com.test.restaurant.data.model.Shop
import com.test.restaurant.domain.exceptions.ErrorModel

interface UseCaseCallback<T> {

    fun onSuccess(result: Resource<Root>)

    fun onError(errorModel: ErrorModel?)
}