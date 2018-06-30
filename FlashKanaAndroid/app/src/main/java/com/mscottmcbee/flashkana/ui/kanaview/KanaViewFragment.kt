package com.mscottmcbee.flashkana.ui.kanaview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.R.id.fragment_kana_view_answer
import com.mscottmcbee.flashkana.R.id.fragment_kana_view_glyph
import com.mscottmcbee.flashkana.model.KanaObject
import kotlinx.android.synthetic.main.fragment_kana_view.*
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.mscottmcbee.flashkana.databinding.FragmentKanaViewHelloBinding


class KanaViewFragment : Fragment(), KanaViewContract.View {

    override lateinit var presenter: KanaViewContract.Presenter

    lateinit var viewModel: KanaViewViewModel

    companion object {
        fun newInstance(): KanaViewFragment {
            return KanaViewFragment()
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModel = KanaViewViewModel()
        val binding = FragmentKanaViewHelloBinding.inflate(inflater,container,false)
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    //    fragment_kana_view_button.setOnClickListener { _ ->
    //        presenter.onMainClicked()
     //   }

      //  presenter.setup()
    }

    override
    fun showKana(kanaObject: KanaObject) {
    //    fragment_kana_view_glyph.text = kanaObject.glyph
    //    fragment_kana_view_answer.text = kanaObject.answer
    }

    override fun onPause() {
        super.onPause()
     //   presenter.updateCardsViewed()
    }

}