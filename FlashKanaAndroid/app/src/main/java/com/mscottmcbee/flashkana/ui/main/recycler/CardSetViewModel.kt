package com.mscottmcbee.flashkana.ui.main.recycler

import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableInt
import androidx.navigation.Navigation
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.dataobjects.CardSet
import com.mscottmcbee.flashkana.ui.cardquiz.multiplechoice.CardsetMCQuizFragment
import com.mscottmcbee.flashkana.ui.cardreview.CardsetReviewFragment

class CardSetViewModel(var model: CardSet) {

    var expanded: ObservableInt = ObservableInt(View.VISIBLE)

    fun toggleExpand(v: View) {
    }

    fun onViewClicked(view: View) {
        var bundle = Bundle().apply { putString(CardsetReviewFragment.Model_ID, model.id) }
        Navigation.findNavController(view).navigate(R.id.main_to_kanaview, bundle)
    }

    fun onQuizClicked(view: View) {
        var bundle = Bundle().apply { putString(CardsetMCQuizFragment.Model_ID, model.id) }
        Navigation.findNavController(view).navigate(R.id.main_to_picker, bundle)
    }


}