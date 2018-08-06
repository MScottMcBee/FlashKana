package com.mscottmcbee.flashkana.ui.cardquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.ModelProvider
import com.mscottmcbee.flashkana.ui.stats.StatsFragment

class StatsActivity : AppCompatActivity() {

    companion object {
        const val Model_ID: String = "model_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        val id = intent.getIntExtra(Model_ID, 0)

        val flashCardSet: IFlashCardModel = ModelProvider.instance.getModelByID(id)

        title = "Statistics for ${flashCardSet.getSetName()}"

        val fragment: StatsFragment = StatsFragment.newInstance()

        val bundle = Bundle()
        bundle.putInt("id", id)
      //  fragment.arguments = bundle

      //  ActivityUtils.addFragment(supportFragmentManager, fragment, R.id.stats_fragment_holder)
    }

}
