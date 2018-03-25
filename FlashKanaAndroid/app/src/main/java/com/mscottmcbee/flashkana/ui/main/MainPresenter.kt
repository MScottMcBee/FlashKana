package com.mscottmcbee.flashkana.ui.main

class MainPresenter(val view: MainContract.View)
    : MainContract.Presenter, KanaSetRecyclerInterface {

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

    override fun goToFlashCardStats(id: Int) {
        view.onFlashSetMoreClicked(id)
    }

    override fun getRecyclerHandler(): KanaSetRecyclerInterface {
        return this
    }
}