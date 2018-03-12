package com.mscottmcbee.flashkana.ui.main

import android.util.Log

class MainPresenter(val view: MainContract.View)
    : MainContract.Presenter, MainRecyclerInterface {

    init {
        view.presenter = this
    }

    override fun setup() {

    }

    override fun goToFlashCardView(id: Int) {
        view.onFlashCardSetClicked(id)
    }

    override fun goToFlashCardQuiz(id: Int) {
        view.onFlashQuizSetClicked(id)
    }

    override fun goToFlashCardMultiple(id: Int) {
        Log.d("aaa", "goToFlashCardMultiple, $id")
    }

    override fun getRecyclerHandler(): MainRecyclerInterface {
        return this
    }

}