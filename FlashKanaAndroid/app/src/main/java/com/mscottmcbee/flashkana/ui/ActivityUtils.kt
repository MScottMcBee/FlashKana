package com.mscottmcbee.flashkana.ui

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.mscottmcbee.flashkana.R

class ActivityUtils{

    companion object {

        fun addFragment(fragmentManager: FragmentManager, fragment: Fragment, frameID: Int){
            var transaction = fragmentManager.beginTransaction()
            transaction.replace(frameID, fragment, "mainFrag")
            transaction.commit()

        }
    }
}