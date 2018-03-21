package com.mscottmcbee.flashkana.ui.kanaview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.ModelProvider
import com.mscottmcbee.flashkana.ui.ActivityUtils

class KanaViewActivity : AppCompatActivity() {

    companion object {
        const val Model_ID: String = "model_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kana_view)
        val id = intent.getIntExtra(Model_ID, 0)

        val flashCardSet: IFlashCardModel = ModelProvider.instance.getModelByID(id)

        title = flashCardSet.getSetName()

        val fragment: KanaViewFragment = KanaViewFragment.newInstance()
        KanaViewPresenter(fragment, flashCardSet)

        ActivityUtils.addFragment(supportFragmentManager, fragment, R.id.kana_view_fragment_holder)
    }

}
