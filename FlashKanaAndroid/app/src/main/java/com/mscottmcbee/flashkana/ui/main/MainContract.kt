package com.mscottmcbee.flashkana.ui.main

import com.mscottmcbee.flashkana.BaseView
import com.mscottmcbee.flashkana.model.KanaObject

interface MainContract{

    interface View : BaseView<Presenter> {
    }

    interface Presenter {
        fun setup()
        fun onHiraganaClicked()
    }
}