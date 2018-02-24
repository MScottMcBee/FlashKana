package com.mscottmcbee.flashkana.ui.kanaview

import com.mscottmcbee.flashkana.model.HiraganaModel

class KanaViewPresenter(val view: KanaViewContract.View)
    : KanaViewContract.Presenter {

    init {
        view.presenter = this
    }

    override fun setup(){
        view.showKana(HiraganaModel.getRandomHiragana())
    }

    override fun onMainClicked() {
        view.showKana(HiraganaModel.getRandomHiragana())
    }

}