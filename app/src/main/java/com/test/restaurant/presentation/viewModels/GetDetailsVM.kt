package com.test.restaurant.presentation.viewModels

import androidx.lifecycle.*
import com.example.restaurant.utils.Resource
import com.test.restaurant.data.model.Shop
import com.test.restaurant.domain.GetDetails
import com.test.restaurant.domain.base.UseCaseCallback
import com.test.restaurant.domain.exceptions.ErrorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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