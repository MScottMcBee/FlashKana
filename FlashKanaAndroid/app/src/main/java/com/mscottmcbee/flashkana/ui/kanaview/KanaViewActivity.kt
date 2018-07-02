package com.mscottmcbee.flashkana.ui.kanaview

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.FragmentKanaViewBinding
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.ModelProvider
import com.mscottmcbee.flashkana.ui.ActivityUtils

class KanaViewActivity : AppCompatActivity() {

    companion object {
        const val Model_ID: String = "model_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:FragmentKanaViewBinding = DataBindingUtil.setContentView(this, R.layout.fragment_kana_view)
        val id = intent.getIntExtra(Model_ID, 0)

        val flashCardSet: IFlashCardModel = ModelProvider.instance.getModelByID(id)
        title = flashCardSet.getSetName()

        val viewModel = KanaViewViewModel(flashCardSet)
        binding.viewmodel = viewModel

    }

}
