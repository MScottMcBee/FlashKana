package com.mscottmcbee.flashkana.ui.main

import com.mscottmcbee.flashkana.BaseView

interface MainContract {

    interface View : BaseView<Presenter> {
        fun onFlashCardSetClicked(id: Int)
        fun onFlashQuizSetClicked(id: Int)
        fun onFlashSetMoreClicked(id: Int)
    }

    interface Presenter {
        fun setup()
        fun getRecyclerHandler(): KanaSetRecyclerInterface
    }
}