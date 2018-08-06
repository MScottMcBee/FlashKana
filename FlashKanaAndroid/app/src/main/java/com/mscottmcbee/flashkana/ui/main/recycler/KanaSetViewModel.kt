package com.mscottmcbee.flashkana.ui.main.recycler

import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableInt
import androidx.navigation.Navigation
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.GenericModel
import com.mscottmcbee.flashkana.ui.cardquiz.CardQuizFragment
import com.mscottmcbee.flashkana.ui.kanaview.KanaViewFragment

class KanaSetViewModel(var model: GenericModel){

    var expanded: ObservableInt = ObservableInt(View.VISIBLE)

    fun toggleExpand(v: View){
     /*   when(expanded.get()){
            View.VISIBLE -> expanded.set(View.GONE)
            else ->  expanded.set(View.VISIBLE)
        }*/
    }

    fun onViewClicked(view: View){
        var bundle = Bundle().apply{putInt(KanaViewFragment.Model_ID,model.id)}
        Navigation.findNavController(view).navigate(R.id.main_to_kanaview,bundle)
    }

    fun onQuizClicked(view: View){
        var bundle = Bundle().apply{putInt(CardQuizFragment.Model_ID,model.id)}
        Navigation.findNavController(view).navigate(R.id.main_to_cardquiz,bundle)
    }


}