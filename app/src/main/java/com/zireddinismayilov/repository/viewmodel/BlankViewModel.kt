package com.zireddinismayilov.repository.viewmodel

import androidx.lifecycle.ViewModel
import com.zireddinismayilov.repository.repository.DataRepository
import com.zireddinismayilov.repository.repository.IFailure

class BlankViewModel : ViewModel() {
    fun getData() {
        DataRepository().getDummyData(object : IFailure {
            override fun onFail(message: String) {
                //
            }
        })
    }
}