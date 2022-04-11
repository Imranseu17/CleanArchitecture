package com.test.restaurant.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurant.utils.Resource
import com.test.restaurant.data.model.Root
import com.test.restaurant.data.model.Shop
import com.test.restaurant.domain.GetPopularrestaurants
import com.test.restaurant.domain.exceptions.ErrorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchFragmentVM @Inject constructor(
    private val getPopularrestaurants: GetPopularrestaurants
) : ViewModel() {

    private val _restaurant by lazy { MutableLiveData<Resource<Shop>>() }
    val restaurant: LiveData<Resource<Shop>> get() = _restaurant


    private val _error by lazy { MutableLiveData<ErrorModel>() }
    val error: LiveData<ErrorModel> get() = _error

    /**
     * Called when user first loads the app and get the flow of paging data.
     */
    suspend fun getPopularrestaurants(): Response<Root> {
        return getPopularrestaurants.call()
    }

}


