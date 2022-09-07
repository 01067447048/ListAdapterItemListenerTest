package com.jaehyeon.listadapteritemlistenertest.repository

import com.jaehyeon.listadapteritemlistenertest.model.CustomDataModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by Jaehyeon on 2022/09/07.
 */
interface MainRepository {

    fun getCustomDataModels(): Flow<List<CustomDataModel>>

}