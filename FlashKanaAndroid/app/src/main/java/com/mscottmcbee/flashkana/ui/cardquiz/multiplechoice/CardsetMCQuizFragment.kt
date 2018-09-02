package com.mscottmcbee.flashkana.ui.cardquiz.multiplechoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.FragmentCardsetQuizBinding
import com.mscottmcbee.flashkana.databinding.FragmentCardsetQuizMcBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class CardsetMCQuizFragment : Fragment() {

    companion object {
        const val Model_ID: String = "model_id"
    }

    var setId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setId = arguments?.getString(Model_ID, "") ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var viewModelMC: CardsetMCQuizViewModel = getViewModel { parametersOf(setId) }

        var binding: FragmentCardsetQuizMcBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_cardset_quiz_mc, container, false)
        binding.viewmodel = viewModelMC
        activity?.title = viewModelMC.getCardSetTitle()

        (activity as AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)

        return binding.root
    }

}