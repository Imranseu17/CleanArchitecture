package com.test.restaurant.data.remote.connection

import android.content.Context
import com.test.moviehub.R

import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/** interceptor to intercept auth in requests*/
class AuthTokenInterceptor @Inject constructor(@ApplicationContext private val context: Context)
    : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader(
                    "Content-Type",
                    context.getString(R.string.json)
                )
                .build()
        )
    }
}