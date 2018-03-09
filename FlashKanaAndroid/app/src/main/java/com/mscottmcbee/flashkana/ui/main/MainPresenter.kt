package com.mscottmcbee.flashkana.ui.main

import android.util.Log
import com.mscottmcbee.flashkana.ui.main.MainRecyclerInterface

class MainPresenter( val view: MainContract.View)
    : MainContract.Presenter, MainRecyclerInterface {

        init {
            view.presenter = this
        }

        override fun setup() {
        }

        override fun aaa(index: Int) {
            Log.d("AAA", "Hello, $index")
        }

        override fun bbb(index: Int) {
            Log.d("AAA", "Goodbye, $index")
        }

        override fun getRecyclerHandler(): MainRecyclerInterface {
            return this
        }

}