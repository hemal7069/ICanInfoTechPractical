package com.iCan.infotech.model

import com.iCan.infotech.data.OperationCallback
import com.iCan.infotech.model.product.Product

interface ProductDataSource {
    fun retrieveProducts(
        userId: Int,
        token: String,
        categoryId: Int,
        languageId: Int,
        filterType: Int,
        fromId: Int,
        toId: Int,
        callback: OperationCallback<Product>
    )

    fun cancel()
}