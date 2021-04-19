package com.iCan.infotech.data

import com.iCan.infotech.model.ProductDataSource
import com.iCan.infotech.model.product.ProductByCategory
import com.iCan.infotech.model.product.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRemoteDataSource(apiClient: ApiClient) : ProductDataSource {
    private var call: Call<ProductByCategory>? = null
    private val service = apiClient.build()

    override fun retrieveProducts(
        userId: Int,
        token: String,
        categoryId: Int,
        languageId: Int,
        filterType: Int,
        fromId: Int,
        toId: Int,
        callback: OperationCallback<Product>
    ) {
        call = service?.getProductByCategory(
            userId,
            token,
            categoryId,
            languageId,
            filterType,
            fromId,
            toId,
        )

        call?.enqueue(object : Callback<ProductByCategory> {
            override fun onResponse(
                call: Call<ProductByCategory>,
                response: Response<ProductByCategory>
            ) {
                response.body()?.let {
                    if (response.isSuccessful && it[0].isSuccess()) {
                        callback.onSuccess(it[0].products)
                    } else {
                        callback.onError("Something went wrong.")
                    }
                }
            }

            override fun onFailure(call: Call<ProductByCategory>, t: Throwable) {
                callback.onError(t.message)
            }

        })
    }

    override fun cancel() {
        call?.cancel()
    }
}