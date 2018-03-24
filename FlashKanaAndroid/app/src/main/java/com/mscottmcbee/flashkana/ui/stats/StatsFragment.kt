package com.mscottmcbee.flashkana.ui.stats

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.ModelProvider
import com.mscottmcbee.flashkana.ui.main.KanaSetRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_stats.*



class StatsFragment :  android.support.v4.app.Fragment(){

    lateinit var flashCardSet: IFlashCardModel

    companion object {
        fun newInstance(): StatsFragment {
            return StatsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_stats, container, false)!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flashCardSet = ModelProvider.instance.getModelByID(arguments.getInt("id"))
        flashCardSet.populateStats()

        val mainAdapter = CardScoreRecyclerAdapter(flashCardSet)
        mainAdapter.setMainRecyclerInterface(null)
        (recyclerview_stats as RecyclerView).apply {
            layoutManager = GridLayoutManager(activity, 3)
            adapter = mainAdapter
        }

        fragment_stats_title.text = flashCardSet.getSetName()
        fragment_stats_description.text = flashCardSet.getSetDescription()
        fragment_stats_overallscore.text = flashCardSet.getStatsScore().toString()
        fragment_stats_numviewed.text = flashCardSet.getStatsViewed().toString()
        fragment_stats_numquizzed.text = flashCardSet.getStatsQuizzed().toString()
    }
}