package com.mscottmcbee.flashkana.ui.cardquiz.quiz

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.mscottmcbee.flashkana.model.Repository
import com.mscottmcbee.flashkana.model.dataobjects.Card
import com.mscottmcbee.flashkana.model.dataobjects.CardSet
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.operators.observable.ObservableReplay.observeOn
import java.util.concurrent.TimeUnit
import androidx.core.view.ViewCompat.setAlpha
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.setTag
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mscottmcbee.flashkana.R


class CardsetQuizViewModel(cardSetId: String, repository: Repository) : ViewModel() {

    private var cardSet: CardSet = repository.getCardSetByID(cardSetId) ?: CardSet()
    var glyph = ObservableField<String>("")
    private var lastCard: Card? = null
    private lateinit var currentCard: Card
    var answerAttempt: ObservableField<String> = ObservableField("")

    var results: MutableLiveData<String> = MutableLiveData<String>().also { it.value="" }
    var spree: ObservableField<Int> = ObservableField(0)

    private var misses: Int = 0

    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    init {
        showNewCard()
    }

    fun onClick() {
        var x = currentCard.answers.filter { it.toUpperCase() == answerAttempt.get()?.toUpperCase() }
        if (x.count() > 0) {
            showNewCard()
            feedback("correct")
            spree.set(spree.get()?.plus(1)) // I hate it
            misses = 0
        } else {
            misses++
            feedback(when{
                misses>=3 -> "answer: ${currentCard.answers[0]}"
                else -> "incorrect"
            })
            answerAttempt.set("")
            spree.set(0)
        }
    }

    private fun feedback(message: String) {
        results.postValue(message)
        disposable.dispose()
        disposable.add(Observable.timer(2500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    results.postValue("")
                })
    }

    fun getCardSetTitle(): String {
        return cardSet.title
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        answerAttempt.set(s.toString())
    }

    private fun showNewCard() {
        currentCard = cardSet.getRandomCard() ?: return
        while (lastCard == currentCard) {
            currentCard = cardSet.getRandomCard()?: return
        }
        lastCard = currentCard

        glyph.set(currentCard.question)
        answerAttempt.set("")
    }
}