package com.mscottmcbee.flashkana.ui.kanaview

import com.mscottmcbee.flashkana.BaseView
import com.mscottmcbee.flashkana.model.KanaObject

interface KanaViewContract{

    interface View : BaseView<Presenter> {
        fun showKana(kanaObject: KanaObject)

    }

    interface Presenter {
        fun setup()
        fun onMainClicked()
    }
}