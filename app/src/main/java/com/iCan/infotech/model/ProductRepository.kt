package com.iCan.infotech.model

import com.iCan.infotech.data.OperationCallback
import com.iCan.infotech.model.product.Product

class ProductRepository(private val productDataSource: ProductDataSource) {
    fun fetchProducts(
        userId: Int,
        token: String,
        categoryId: Int,
        languageId: Int,
        filterType: Int,
        fromId: Int,
        toId: Int,
        callback: OperationCallback<Product>
    ) {
        productDataSource.retrieveProducts(
            userId,
            token,
            categoryId,
            languageId,
            filterType,
            fromId,
            toId,
            callback
        )
    }

    fun cancel() {
        productDataSource.cancel()
    }
}