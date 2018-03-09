package com.mscottmcbee.flashkana.ui.quizview

import com.mscottmcbee.flashkana.BaseView
import com.mscottmcbee.flashkana.model.KanaObject

interface QuizViewContract {

    interface View : BaseView<Presenter> {
        fun showKana(kanaObject: KanaObject)
        fun showAnswer(answer: String, index: Int)
    }

    interface Presenter {
        fun setup()
        fun onAnswerClicked(index: Int)
    }
}