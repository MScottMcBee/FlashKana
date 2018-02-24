package com.mscottmcbee.flashkana.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.KanaObject
import com.mscottmcbee.flashkana.ui.kanaview.KanaViewActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment() : Fragment(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    companion object {
        //https://stackoverflow.com/questions/9245408/best-practice-for-instantiating-a-new-android-fragment/9245510#9245510
        fun newInstance(): MainFragment {
            var mainFragment = MainFragment()
            return mainFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_main, container, false)!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main_fragment_hiragana_button.setOnClickListener { _ ->
            val intent = Intent(context, KanaViewActivity::class.java)
            intent.putExtra(KanaViewActivity.SECRET_MESSAGE,"ur a damn nerd")
            startActivity(intent)
        }

        presenter.setup()
    }

}