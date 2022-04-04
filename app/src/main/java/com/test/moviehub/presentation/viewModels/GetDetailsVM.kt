package com.test.moviehub.presentation.viewModels

import androidx.lifecycle.*
import com.example.restaurant.utils.Resource
import com.test.moviehub.data.model.Root
import com.test.moviehub.data.model.Shop
import com.test.moviehub.domain.GetDetails
import com.test.moviehub.domain.Repository
import com.test.moviehub.domain.base.UseCaseCallback
import com.test.moviehub.domain.exceptions.ErrorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class GetDetailsVM @Inject constructor(
    private val getDetails: GetDetails
) : ViewModel() {

    private val _movie by lazy { MutableLiveData<Resource<Shop>>() }
    val movie: LiveData<Resource<Shop>> get() = _movie


    private val _error by lazy { MutableLiveData<ErrorModel>() }
    val error: LiveData<ErrorModel> get() = _error



    /**
     * Called to get details of the movie.
     * @param id The movie id to request further details.
     */
    fun getDetails(id: String) {
        viewModelScope.launch {
            getDetails.call(id, onResult = object : UseCaseCallback {
                override fun onSuccess(result: Resource<Shop>) {
                    _movie.value = (result)
                }

                override fun onError(errorModel: ErrorModel?) {
                    _error.value = errorModel
                }
            })
        }
    }

}