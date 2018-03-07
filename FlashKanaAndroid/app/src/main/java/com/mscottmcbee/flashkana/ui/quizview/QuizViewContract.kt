package com.mscottmcbee.flashkana.ui.quizview

import com.mscottmcbee.flashkana.BaseView
import com.mscottmcbee.flashkana.model.KanaObject

interface QuizViewContract{

    interface View : BaseView<Presenter> {
        fun showKana(kanaObject: KanaObject)
        fun showAnswer1(answer: String)
        fun showAnswer2(string: String)
        fun showAnswer3(string: String)
        fun showAnswer4(string: String)

    }

    interface Presenter {
        fun setup()
        fun onAnswerClicked(answerNumber: Int)
        fun onCorrectClicked()
        fun onIncorrectClicked()
    }
}