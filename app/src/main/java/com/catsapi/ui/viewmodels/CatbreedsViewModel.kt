package com.catsapi.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catsapi.data.network.CatbreedApiClient
import com.catsapi.ui.models.CatbreedBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CatbreedsViewModel @Inject constructor(
    private val apiClient: CatbreedApiClient
): ViewModel() {

    private val _showLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val showLoading: LiveData<Boolean> = _showLoading

    private val _catsResponse: MutableLiveData<List<CatbreedBinding>> = MutableLiveData()
    val catsResponse: LiveData<List<CatbreedBinding>> = _catsResponse

    fun showLoadingSet(isShow: Boolean) {
        _showLoading.value = isShow
    }

    fun getCats() {
        showLoadingSet(true)
        viewModelScope.launch {
            val body = apiClient.getBreeds().body()
            with(body) {
                _catsResponse.value = this?.map { it.toBinding() } ?: emptyList()
                showLoadingSet(false)
            }
        }
    }
}