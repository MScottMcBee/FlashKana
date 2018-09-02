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

class FKRepository() : Repository {
    private var cardSets: MutableLiveData<HashMap<String, CardSet>> = MutableLiveData()
    private var listen: Boolean = false

    init {
        cardSets.value = HashMap()
    }

    @SuppressLint("CheckResult")
    override fun getCardSets(): MutableLiveData<HashMap<String, CardSet>> {
        var sets: HashMap<String, CardSet>? = cardSets.value
        if (sets != null && !listen) {
            val cardColl = FirebaseFirestore.getInstance().collection("cardSets")
            listen = true

            RxFirestore.observeQueryRef(cardColl)
                    .observeOn(Schedulers.io())
                    .map {
                        Log.d("DATA STUFF", "ARE WE CACHE? ${it.metadata.isFromCache}")
                        it.documentChanges.map {
                            Pair(it.type, it.document.toObject(CardSet::class.java).let { cardSet -> cardSet.id = it.document.id; cardSet })
                        }
                    }.subscribe(
                            {

                                for (docPair: Pair<DocumentChange.Type, CardSet> in it) {
                                    var cardSet: CardSet = docPair.second

                                    when (docPair.first) {
                                        DocumentChange.Type.REMOVED -> sets.remove(cardSet.id)
                                        else -> sets[cardSet.id] = cardSet
                                    }
                                }
                                cardSets.postValue(sets)
                            },
                            { Log.d("ERR: ", it.localizedMessage) }
                    )
        }
        return cardSets
    }

    override fun getCardSetByID(id: String): CardSet? {
        return cardSets.value?.get(id)
    }


}