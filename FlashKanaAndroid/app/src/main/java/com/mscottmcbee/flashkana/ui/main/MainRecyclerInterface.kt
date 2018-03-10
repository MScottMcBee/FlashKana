package com.mscottmcbee.flashkana.ui.main

import android.view.View

interface MainRecyclerInterface {
    fun aaa(index: Int)
    fun bbb(index: Int)
    fun goToFlashCardView(id:Int)
    fun goToFlashCardQuiz(id:Int)
    fun goToFlashCardMultiple(id: Int)
    fun closeAllPopouts()
}