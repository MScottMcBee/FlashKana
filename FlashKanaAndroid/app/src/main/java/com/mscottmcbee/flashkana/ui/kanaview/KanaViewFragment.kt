package com.mscottmcbee.flashkana.ui.kanaview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.FragmentKanaViewBinding
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.ModelProvider


class KanaViewFragment : Fragment() {

    companion object {
        const val Model_ID: String = "model_id"
    }

    var setId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setId = arguments?.getInt(Model_ID, 0) ?: 0
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
       var binding: FragmentKanaViewBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kana_view,container,false)

        val flashCardSet: IFlashCardModel = ModelProvider.instance.getModelByID(setId)
        activity?.title = flashCardSet.getSetName()

        val viewModel = KanaViewViewModel(flashCardSet)

        binding.viewmodel = viewModel

        return binding.root
    }

}
