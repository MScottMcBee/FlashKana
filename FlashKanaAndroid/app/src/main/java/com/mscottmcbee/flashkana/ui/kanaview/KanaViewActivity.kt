package com.mscottmcbee.flashkana.ui.kanaview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.ui.ActivityUtils

class KanaViewActivity : AppCompatActivity() {

    companion object {
        val SECRET_MESSAGE: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kana_view)
        Log.d("KanaViewActivity",intent.getStringExtra(SECRET_MESSAGE))

        title = getString(R.string.kana_view_hiragana_title)

        val fragment: KanaViewFragment = KanaViewFragment.newInstance()
        val presenter = KanaViewPresenter(fragment)

        ActivityUtils.addFragment(supportFragmentManager, fragment, R.id.kana_view_fragment_holder)
    }

}
