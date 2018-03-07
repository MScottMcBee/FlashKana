package com.mscottmcbee.flashkana.ui.quizview

import android.util.Log
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.KanaObject
import java.util.*

class QuizViewPresenter(val view: QuizViewContract.View, val flashCardSet: IFlashCardModel)
    : QuizViewContract.Presenter {

    val totalQuestions = 20
    var currentQuestion = 1
    var numCorrect = 0
    var numIncorrect = 0
    var isAnswerCorrect = mutableListOf(false, false, false, false)
    var showAnswers: MutableList<(String) -> Unit> = mutableListOf()

    init {
        view.presenter = this
        showAnswers.add({answer: String -> view.showAnswer1(answer)})
        showAnswers.add({answer: String -> view.showAnswer2(answer)})
        showAnswers.add({answer: String -> view.showAnswer3(answer)})
        showAnswers.add({answer: String -> view.showAnswer4(answer)})
    }

    override fun setup() {
        resetQuestion()
    }

    override fun onCorrectClicked() {
        view.showKana(flashCardSet.getRandomCard())
    }

    override fun onIncorrectClicked() {
        view.showKana(flashCardSet.getRandomCard())
    }

    override fun onAnswerClicked(answerNumber: Int) {
        if(isAnswerCorrect[answerNumber]){
            numCorrect++
            currentQuestion++
            if(currentQuestion >= totalQuestions){
                view.showKana(KanaObject(numCorrect.toString(), ""))
            }else {
                resetQuestion()
            }
        } else{
            numIncorrect++
            numCorrect-- //note users can decrement numCorrect by continuously selecting the wrong answer
            (0..3).forEach {
                if(!isAnswerCorrect[it]){
                    showAnswers[it]("")
                }
            }
        }
    }

    fun resetQuestion(){
        Log.i("", "resetQuestion()")
        //set each answer to random wrong ones that are all different
        //note: this requires flash card models to have at least 4 kana objects
        val kanaUsed = mutableListOf<String>("", "", "", "")
        (0..3).forEach {
            Log.i("", "foreach set wrong for ${kanaUsed.toString()} at $it")
            do{
                flashCardSet.getRandomCard().run {
                    Log.i("", "try ${this.answer}")
                    showAnswers[it](this.answer)
                    kanaUsed[it] = this.answer
                }
            }while(it != 0 && kanaUsed.subList(0, it).contains(kanaUsed[it]))
            isAnswerCorrect[it] = false
        }
        //choose a random answer then pair it with a random glyph that isn't being used
        Random().nextInt(3).also {
            Log.i("", "set answer " + it)
            isAnswerCorrect[it] = true
            kanaUsed[it] = ""
            do {
                Log.i("", "try " + kanaUsed.toString())
                with(flashCardSet.getRandomCard()) {
                    Log.i("", "try " + this.answer)
                    if(!kanaUsed.contains(this.answer)) {
                        view.showKana(this)
                        showAnswers[it](this.answer)
                        kanaUsed[it] = this.answer
                    }
                }
            }while(kanaUsed[it] == "")
        }
    }

}