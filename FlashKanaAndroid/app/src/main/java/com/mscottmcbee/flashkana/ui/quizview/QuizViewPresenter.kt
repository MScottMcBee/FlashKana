package com.mscottmcbee.flashkana.ui.quizview

import android.util.Log
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.KanaObject
import java.util.*

class QuizViewPresenter(val view: QuizViewContract.View, val flashCardSet: IFlashCardModel)
    : QuizViewContract.Presenter {

    companion object {
        const val TOTAL_QUESTIONS = 10
    }

    var currentQuestion = 1
    var numCorrect = 0
    var numIncorrect = 0
    var correctAnswer = -1
    val kanaUsed = mutableListOf<String>("", "", "", "")

    init {
        view.presenter = this
    }

    override fun setup() {
        resetQuestion()
    }

    override fun onAnswerClicked(index: Int) {
        if (correctAnswer == index && kanaUsed[index] != "") { //if the answer is right and buttons haven't already been cleared
            numCorrect++
            currentQuestion++
            if (currentQuestion >= TOTAL_QUESTIONS) {
                view.showKana(KanaObject(numCorrect.toString(), ""))
                for (i in 0..3) {
                    kanaUsed[i] = ""
                    view.showAnswer("", i)
                }
            } else {
                resetQuestion()
            }
        } else if (kanaUsed[index] != "") { //if the answer is wrong and buttons haven't already been cleared
            numIncorrect++
            numCorrect--
            for (i in 0..3) {
                if (correctAnswer != i) {
                    kanaUsed[i] = ""
                    view.showAnswer("", i)
                }
            }
        }
    }

    fun resetQuestion() {
        //set each answer to random wrong ones that are all different
        //note: this requires flash card models to have at least 4 kana objects
        for (i in 0..3) {
            do {
                val kana = flashCardSet.getRandomCard().answer
                view.showAnswer(kana, i)
                kanaUsed[i] = kana
            } while (i != 0 && kanaUsed.subList(0, i).contains(kanaUsed[i]))
        }

        //choose a random answer then pair it with a random glyph that isn't being used
        correctAnswer = Random().nextInt(3)
        kanaUsed[correctAnswer] = ""
        var kanaSet: KanaObject
        do {
            kanaSet = flashCardSet.getRandomCard()
        } while (kanaUsed.contains(kanaSet.answer))
        view.showKana(kanaSet)
        view.showAnswer(kanaSet.answer, correctAnswer)
        kanaUsed[correctAnswer] = kanaSet.answer
    }

}