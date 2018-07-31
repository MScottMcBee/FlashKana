package com.mscottmcbee.flashkana.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mscottmcbee.flashkana.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
        val fragment: MainFragment = MainFragment.newInstance()
        MainPresenter(fragment)

        ActivityUtils.addFragment(supportFragmentManager, fragment, R.id.main_fragment_holder)*/
    }


   // override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()


}
