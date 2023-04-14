package com.catsapi.ui

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

    private val _catsResponse: MutableLiveData<List<CatbreedBinding>> = MutableLiveData()
    val catsResponse: LiveData<List<CatbreedBinding>> = _catsResponse


    fun getCats() {
        viewModelScope.launch {
            val body = apiClient.getBreeds().body()
            with(body) {
                _catsResponse.value = this?.map { it.toBinding() } ?: emptyList()
            }
        }
    }
}