package com.zireddinismayilov.repository.api

import com.zireddinismayilov.repository.api.data.ProductDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IApi {
    @GET("products/{id}")
    fun getData(@Path("id") id: Int): Call<ProductDTO?>?
}