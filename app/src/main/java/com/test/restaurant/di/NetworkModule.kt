package com.test.restaurant.di

import android.content.Context
import android.util.Log
import androidx.viewbinding.BuildConfig
import com.test.restaurant.data.remote.connection.AuthTokenInterceptor
import com.test.restaurant.data.remote.connection.RestaurantService
import com.test.restauranthub.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authTokenInterceptor: AuthTokenInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }
        builder.addInterceptor(authTokenInterceptor)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message: String? ->
            if (message != null)
                Log.d(
                    "network_log",
                    message
                )
        }.setLevel(HttpLoggingInterceptor.Level.BODY)


    @Singleton
    @Provides
    fun provideStickersService(
        okHttpClient: OkHttpClient,
        @ApplicationContext mContext: Context,
        gsonConverterFactory: GsonConverterFactory
    ): RestaurantService {
        val retrofit = Retrofit.Builder()
            .baseUrl(mContext.getString(R.string.base_url))
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
        return retrofit.create(RestaurantService::class.java)
    }


}