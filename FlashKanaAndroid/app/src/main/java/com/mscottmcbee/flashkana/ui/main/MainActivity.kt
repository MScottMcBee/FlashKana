package com.mscottmcbee.flashkana.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.ui.ActivityUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment: MainFragment = MainFragment.newInstance()
        val presenter = MainPresenter(fragment)

        ActivityUtils.addFragment(supportFragmentManager, fragment, R.id.main_fragment_holder)
    }

}
