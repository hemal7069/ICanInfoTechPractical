package com.iCan.infotech.data

import com.iCan.infotech.model.product.ProductByCategory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiClient {
    private const val BASE_URL = "http://www.khaam.me/admin/webservices/product.asmx/"

    private var serviceApiInterface: ServiceApiInterface? = null

    fun build(): ServiceApiInterface {
        val builder: Retrofit.Builder = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor())

        val retrofit: Retrofit = builder.client(httpClient.build()).build()
        serviceApiInterface = retrofit.create(
            ServiceApiInterface::class.java
        )

        return serviceApiInterface as ServiceApiInterface
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return httpLoggingInterceptor
    }

    interface ServiceApiInterface {
        @GET("SelectAllProductByCategory")
        fun getProductByCategory(
            @Query("nUserId") userId: Int,
            @Query("cToken") token: String,
            @Query("nCategoryId") categoryId: Int,
            @Query("nLanguageId") languageId: Int,
            @Query("cFilterType") filterType: Int,
            @Query("nFromId") fromId: Int,
            @Query("nToId") toId: Int,
        ): Call<ProductByCategory>
    }
}