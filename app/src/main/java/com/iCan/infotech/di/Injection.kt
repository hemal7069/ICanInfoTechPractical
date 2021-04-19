package com.iCan.infotech.di

import androidx.lifecycle.ViewModelProvider
import com.iCan.infotech.data.ApiClient
import com.iCan.infotech.data.ProductRemoteDataSource
import com.iCan.infotech.model.ProductDataSource
import com.iCan.infotech.model.ProductRepository
import com.iCan.infotech.view_model.ViewModelFactory

object Injection {
    private val productDataSource: ProductDataSource = ProductRemoteDataSource(ApiClient)
    private val productRepository: ProductRepository = ProductRepository(productDataSource)
    private val productViewModelFactory = ViewModelFactory(productRepository)

    fun providerRepository(): ProductDataSource{
        return productDataSource
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return productViewModelFactory
    }
}