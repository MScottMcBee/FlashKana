package com.mscottmcbee.flashkana.ui.main

import com.mscottmcbee.flashkana.BaseView
import com.mscottmcbee.flashkana.ui.main.MainRecyclerInterface

interface MainContract{

    interface View : BaseView<Presenter>{
        fun onFlashCardSetClicked(id: Int)
        fun onFlashQuizSetClicked(id: Int)
    }

    interface Presenter {
        fun setup()
        fun getRecyclerHandler():MainRecyclerInterface
    }
}