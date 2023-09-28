package com.zireddinismayilov.repository

import com.zireddinismayilov.repository.api.RetrofitClient
import com.zireddinismayilov.repository.api.data.ProductDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataFetcher {

    fun getData(callback: IDataCallback) {
        RetrofitClient.instance.getData(2)?.enqueue(object : Callback<ProductDTO?> {
            override fun onResponse(call: Call<ProductDTO?>, response: Response<ProductDTO?>) {
                callback.callback(DataResult.Success(response.body()))
            }

            override fun onFailure(call: Call<ProductDTO?>, t: Throwable) {
                callback.callback(DataResult.Failure(t.message.toString()))
            }

        })
    }

    interface IDataCallback {
        fun callback(result: DataResult)
    }
}