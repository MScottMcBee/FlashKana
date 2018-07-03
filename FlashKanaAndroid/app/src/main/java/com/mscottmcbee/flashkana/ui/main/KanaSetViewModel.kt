package com.mscottmcbee.flashkana.ui.main

import android.databinding.ObservableBoolean
import android.databinding.ObservableInt
import android.util.Log
import android.view.View
import com.mscottmcbee.flashkana.model.GenericModel

class KanaSetViewModel(var model: GenericModel){

    var expanded:ObservableInt = ObservableInt(View.GONE)

    fun toggleExpand(view: View){
        when(expanded.get()){
            View.VISIBLE -> expanded.set(View.GONE)
            else ->  expanded.set(View.VISIBLE)
        }
    }

    fun onViewClicked(view: View){
        Log.d("AAAAAA","view ${model.id}")
    }

    fun onQuizClicked(view: View){
        Log.d("AAAAAA","quiz ${model.id}")
    }

    fun onDeetsClicked(view: View){
        Log.d("AAAAAA","deets ${model.id}")
    }

}