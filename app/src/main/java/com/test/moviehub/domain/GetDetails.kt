package com.test.moviehub.domain

import com.test.moviehub.data.model.Root
import com.test.moviehub.domain.base.UseCase
import com.test.moviehub.domain.exceptions.IErrorHandler
import retrofit2.Response
import javax.inject.Inject

class GetDetails @Inject constructor(
    private val repository: Repository,
    errorHandler: IErrorHandler
) : UseCase<Response<Root>, String>(errorHandler) {


    override suspend fun run(params: String?): Response<Root> {
      return repository.getDetails("f5c06c8896e2d2d4",params,"json")
    }
}