package com.test.restaurant.domain.base

import android.provider.DocumentsContract
import com.example.restaurant.utils.Resource
import com.test.restaurant.data.model.Root
import com.test.restaurant.data.model.Shop
import com.test.restaurant.domain.exceptions.IErrorHandler
import kotlinx.coroutines.CancellationException

abstract class UseCase<Response, Params>(private val errorHandler: IErrorHandler) {

    /**
     * every usecase must implement this method for implement business core
     */
    abstract suspend fun run(params: Params? = null): Response

    /**
     * an interface that presentation layer work with this
     */
    suspend fun call(
        params: Params? = null,
        onResult: (UseCaseCallback<Resource<Root>>)?
    ) {
        try {
            val result = run(params)
            onResult?.onSuccess(result)
            println("$TAG Response: $result")
        } catch (e: CancellationException) {
            println("$TAG Error: $e")
            onResult?.onError(errorHandler.handleException(e))
        } catch (e: Exception) {
            println("$TAG Error:$e cause: ${e.cause}")
            onResult?.onError(errorHandler.handleException(e))
        }
    }

    companion object {
        private val TAG = UseCase::class.java.name
    }

}