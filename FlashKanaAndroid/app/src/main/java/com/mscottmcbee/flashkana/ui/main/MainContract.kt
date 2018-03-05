package com.mscottmcbee.flashkana.ui.main

import com.mscottmcbee.flashkana.BaseView

interface MainContract{

    interface View : BaseView<Presenter>

    interface Presenter {
        fun setup()
    }
}