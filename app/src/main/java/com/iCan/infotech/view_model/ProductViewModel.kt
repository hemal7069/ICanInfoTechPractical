package com.iCan.infotech.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iCan.infotech.data.OperationCallback
import com.iCan.infotech.model.ProductRepository
import com.iCan.infotech.model.product.Product

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    private val _products = MutableLiveData<List<Product>>().apply { value = emptyList() }
    val products: LiveData<List<Product>> = _products

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    fun loadProducts(
        userId: Int,
        token: String,
        categoryId: Int,
        languageId: Int,
        filterType: Int,
        fromId: Int,
        toId: Int,
    ) {
        _isViewLoading.value = true

        repository.fetchProducts(
            userId,
            token,
            categoryId,
            languageId,
            filterType,
            fromId,
            toId,
            object : OperationCallback<Product> {
                override fun onSuccess(data: List<Product>?) {
                    _isViewLoading.value = false

                    if (data.isNullOrEmpty()) {
                        _isEmptyList.value = true

                    } else {
                        _products.value = data
                    }
                }

                override fun onError(error: String?) {
                    _isViewLoading.value = false
                    _onMessageError.value = error
                }

            })
    }
}