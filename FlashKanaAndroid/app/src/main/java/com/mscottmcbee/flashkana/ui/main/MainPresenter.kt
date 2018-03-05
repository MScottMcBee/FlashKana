package com.mscottmcbee.flashkana.ui.main

import com.mscottmcbee.flashkana.model.HiraganaModel

class MainPresenter( val view: MainContract.View)
    : MainContract.Presenter {

    init {
        view.presenter = this
    }

    override fun setup(){
    }

}