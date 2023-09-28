package com.zireddinismayilov.repository.repository

import androidx.lifecycle.MutableLiveData
import com.zireddinismayilov.repository.DataFetcher
import com.zireddinismayilov.repository.DataResult
import com.zireddinismayilov.repository.api.data.ProductDTO

class DataRepository {
    var data = MutableLiveData<ProductDTO>()
    fun getDummyData(iFailure: IFailure) {
        DataFetcher().getData(object : DataFetcher.IDataCallback {
            override fun callback(result: DataResult) {
                when (result) {
                    is DataResult.Success<*> -> {
                        data.postValue(result.data as ProductDTO)
                    }

                    is DataResult.Failure -> {
                        iFailure.onFail(result.message)
                    }

                    is DataResult.FailureHTTP -> {}
                }
            }
        })
    }
}

interface IFailure {
    fun onFail(message: String)
}