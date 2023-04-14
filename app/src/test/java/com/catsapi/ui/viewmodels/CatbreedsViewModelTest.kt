package com.catsapi.ui.viewmodels

import com.catsapi.data.models.CatbreedResponse
import com.catsapi.data.network.CatbreedApiClient
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class CatbreedsViewModelTest {
    @RelaxedMockK

    private lateinit var apiClient: CatbreedApiClient
    private lateinit var viewModel: CatbreedsViewModel



    @Before
    fun onStart() {

    }

    @Test
    fun `when viewmodel call the api cat list`() =
        runBlocking {
            val list = listOf(
                CatbreedResponse("as", "qw", "country", "4", "image"),
                CatbreedResponse("a1s", "qw1", "cou2ntry", "4", "image")
            )
            //
            coEvery { apiClient.getBreeds() } returns list
            //When
            viewModel.getCats()
            //Then
            assert(viewModel.catsResponse.value == list))
        }

}