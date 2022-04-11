package com.test.restaurant.di

import com.test.restaurant.data.RepositoryImpl
import com.test.restaurant.data.remote.RemoteDataSource
import com.test.restaurant.data.remote.RemoteDataSourceImpl
import com.test.restaurant.data.remote.connection.RestaurantService
import com.test.restaurant.domain.Repository
import com.test.restaurant.domain.exceptions.IErrorHandler
import com.test.restaurant.data.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSourceImpl: RemoteDataSourceImpl,
    ): Repository {
        return RepositoryImpl(remoteDataSourceImpl)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        service: RestaurantService
    ): RemoteDataSource {
        return RemoteDataSourceImpl(service)
    }

    @Singleton
    @Provides
    fun provideErrorHandler(): IErrorHandler {
        return ErrorHandler()
    }
}