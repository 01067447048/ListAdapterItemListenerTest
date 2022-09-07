package com.jaehyeon.listadapteritemlistenertest.util

/**
 * Created by Jaehyeon on 2022/09/07.
 */
interface CustomItemTouchCallBackInterface {
    fun onItemMove(from_position: Int, to_position: Int): Boolean
    fun onItemSwipe(position: Int)
}