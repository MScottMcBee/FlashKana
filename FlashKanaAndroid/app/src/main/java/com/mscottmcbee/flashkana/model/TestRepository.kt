package com.mscottmcbee.flashkana.model

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.mscottmcbee.flashkana.model.dataobjects.Card
import com.mscottmcbee.flashkana.model.dataobjects.CardSet
import durdinapps.rxfirebase2.RxFirestore
import io.reactivex.schedulers.Schedulers

class TestRepository() : Repository {
    private var cardSets: MutableLiveData<HashMap<String, CardSet>> = MutableLiveData()

    override fun getCardSets(): MutableLiveData<HashMap<String, CardSet>> {
        var sets = HashMap<String, CardSet>()
        var cardSet = CardSet()
        cardSet.title = "hello"
        sets["a"] = cardSet

        cardSet.cards.add(Card().also {
            it.question = "a"
            it.answers.add("a")
        })

        cardSet.cards.add(Card().also {
            it.question = "b"
            it.answers.add("b")
        })

        cardSet.cards.add(Card().also {
            it.question = "c"
            it.answers.add("c")
        })

        cardSets.value = sets

        sets["b"] = CardSet().also { it.title = "Honk" }

        return cardSets
    }

    override fun getCardSetByID(id: String): CardSet? {
        var x = getCardSets()
        var y = x.value!![id]
        return y
    }


}