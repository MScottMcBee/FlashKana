package com.mscottmcbee.flashkana.ui.cardquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.FragmentQuizViewBinding

class CardQuizFragment : Fragment(){

    companion object {
        const val Model_ID: String = "model_id"
    }

    var setId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setId = arguments?.getInt(Model_ID, 0) ?: 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var viewModel = ViewModelProviders.of(this, CardQuizViewModelFactory(setId)).get(CardQuizViewModel::class.java)
        viewModel.setCardSetId(setId)

        var binding: FragmentQuizViewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_quiz_view,container,false)
        binding.viewmodel = viewModel
        activity?.title = viewModel.getCardSetTitle()


        (activity as AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)


        return binding.root
    }

}