package com.iCan.infotech.model.product

import com.google.gson.annotations.SerializedName

data class ProductByCategoryItem(
    @SerializedName("nTotalRecords")
    var nTotalRecords: Int,

    @SerializedName("result")
    var products: List<Product>,

    @SerializedName("Success")
    var success: String
) {
    fun isSuccess(): Boolean = (success == "1")
}