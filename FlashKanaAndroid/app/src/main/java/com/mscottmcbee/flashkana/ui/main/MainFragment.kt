package com.mscottmcbee.flashkana.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.ui.kanaview.KanaViewActivity
import com.mscottmcbee.flashkana.ui.quizview.QuizViewActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainContract.View {

    override lateinit var presenter: MainContract.Presenter

    companion object {
        //https://stackoverflow.com/questions/9245408/best-practice-for-instantiating-a-new-android-fragment/9245510#9245510
        fun newInstance(): MainFragment {
            val mainFragment = MainFragment()
            return mainFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_main, container, false)!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainAdapter = MainRecyclerAdapter()
        mainAdapter.setMainRecyclerInterface(presenter.getRecyclerHandler())
        (recyclerview_main as RecyclerView).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mainAdapter

            presenter.setup()
        }
    }

    override fun onFlashCardSetClicked(id: Int) {
        val intent = Intent(context, KanaViewActivity::class.java)
        intent.putExtra(KanaViewActivity.Model_ID, id)
        startActivity(intent)
    }

    override fun onFlashQuizSetClicked(id: Int) {
        val intent = Intent(context, QuizViewActivity::class.java)
        intent.putExtra(KanaViewActivity.Model_ID, id)
        startActivity(intent)
    }

}