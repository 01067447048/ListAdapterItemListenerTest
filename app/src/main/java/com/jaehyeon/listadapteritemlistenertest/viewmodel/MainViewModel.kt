package com.jaehyeon.listadapteritemlistenertest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaehyeon.listadapteritemlistenertest.model.CustomDataModel
import com.jaehyeon.listadapteritemlistenertest.repository.MainRepositoryImpl
import com.jaehyeon.listadapteritemlistenertest.util.ListLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Jaehyeon on 2022/09/07.
 */
class MainViewModel: ViewModel() {

    private val repository = MainRepositoryImpl()

    private val _state = MutableStateFlow<List<CustomDataModel>>(emptyList())
    val state: StateFlow<List<CustomDataModel>> get() = _state


    private fun initData() {
        repository.getCustomDataModels().onEach {
            _state.value = it
        }.launchIn(viewModelScope)
    }

    init {
        initData()
    }
}