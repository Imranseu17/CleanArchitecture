package com.test.moviehub.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.restaurant.utils.Resource
import com.test.moviehub.data.model.Root
import com.test.moviehub.data.model.Shop
import com.test.moviehub.domain.GetPopularMovies
import com.test.moviehub.domain.exceptions.ErrorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchFragmentVM @Inject constructor(
    private val getPopularMovies: GetPopularMovies
) : ViewModel() {

    private val _movie by lazy { MutableLiveData<Resource<Shop>>() }
    val movie: LiveData<Resource<Shop>> get() = _movie


    private val _error by lazy { MutableLiveData<ErrorModel>() }
    val error: LiveData<ErrorModel> get() = _error

    /**
     * Called when user first loads the app and get the flow of paging data.
     */
    suspend fun getPopularMovies(): Response<Root> {
        return getPopularMovies.call()
    }

}


