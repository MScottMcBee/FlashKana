package com.mscottmcbee.flashkana.ui.kanaquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.IFlashCardModel
import com.mscottmcbee.flashkana.model.ModelProvider

class KanaQuizActivity : AppCompatActivity() {

    companion object {
        const val Model_ID: String = "model_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_view)
        val id = intent.getIntExtra(Model_ID, 0)

        val flashCardSet: IFlashCardModel = ModelProvider.instance.getModelByID(id)

        title = flashCardSet.getSetName()

        val fragment: KanaQuizFragment = KanaQuizFragment.newInstance()
        //KanaQuizPresenter(fragment, flashCardSet)

    //    ActivityUtils.addFragment(supportFragmentManager, fragment, R.id.quiz_view_fragment_holder)
    }

}
