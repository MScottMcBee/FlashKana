package com.mscottmcbee.flashkana.ui.kanaview

import com.mscottmcbee.flashkana.model.IFlashCardModel

class KanaViewPresenter(val view: KanaViewContract.View, private val flashCardSet: IFlashCardModel)
    : KanaViewContract.Presenter {

    private var cardsViewed = 0

    init {
        view.presenter = this
    }

    override fun setup() {
        view.showKana(flashCardSet.getRandomCard())
    }

    override fun onMainClicked() {
        view.showKana(flashCardSet.getRandomCard())
        cardsViewed++
    }

    override fun updateCardsViewed() {
        flashCardSet.updateCardsViewed(cardsViewed)
        cardsViewed = 0
    }

}