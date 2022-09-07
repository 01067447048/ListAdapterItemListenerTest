package com.jaehyeon.listadapteritemlistenertest.repository

import com.jaehyeon.listadapteritemlistenertest.model.CustomDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Jaehyeon on 2022/09/07.
 */
class MainRepositoryImpl : MainRepository {

    override fun getCustomDataModels(): Flow<List<CustomDataModel>> = flow {
        emit(
            listOf(
                CustomDataModel(1,"가나다", "11111111", true),
                CustomDataModel(2,"라마바", "22222222", false),
                CustomDataModel(3,"사아자", "33333333", false),
                CustomDataModel(4,"차카타", "44444444", false),
                CustomDataModel(5,"파하", "55555555", true)
            )
        )
    }

}