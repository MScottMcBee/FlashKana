package com.mscottmcbee.flashkana.ui.cardreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.FragmentCardsetReviewBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf


class CardsetReviewFragment : Fragment() {

    companion object {
        const val Model_ID: String = "model_id"
    }

    var setId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        setId = arguments?.getString(Model_ID, "") ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var binding: FragmentCardsetReviewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_cardset_review, container, false)

        var viewModel: CardsetReviewViewModel = getViewModel { parametersOf(setId) }
        binding.viewmodel = viewModel
        activity?.title = viewModel.getCardSetTitle()

        (activity as AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)

        return binding.root
    }

}
