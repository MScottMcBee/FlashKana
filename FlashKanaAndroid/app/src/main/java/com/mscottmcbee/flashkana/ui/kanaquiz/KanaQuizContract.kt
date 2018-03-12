package com.mscottmcbee.flashkana.ui.kanaquiz

import com.mscottmcbee.flashkana.BaseView
import com.mscottmcbee.flashkana.model.KanaObject

interface KanaQuizContract {

    interface View : BaseView<Presenter> {
        fun showKana(kanaObject: KanaObject)
        fun showAnswer(answer: String, index: Int)
        fun fadeOutAnswer(index: Int)
    }

    interface Presenter {
        fun setup()
        fun onAnswerClicked(index: Int)
    }
}