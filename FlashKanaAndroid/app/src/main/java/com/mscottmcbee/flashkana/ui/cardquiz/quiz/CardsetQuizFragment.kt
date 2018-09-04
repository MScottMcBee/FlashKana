package com.mscottmcbee.flashkana.ui.cardquiz.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.FragmentCardsetQuizBinding
import kotlinx.android.synthetic.main.fragment_cardset_quiz.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class CardsetQuizFragment : Fragment() {

    companion object {
        const val Model_ID: String = "model_id"
    }

    private var setId = ""
    private lateinit var viewModel: CardsetQuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setId = arguments?.getString(Model_ID, "") ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = getViewModel { parametersOf(setId) }

        var binding: FragmentCardsetQuizBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_cardset_quiz, container, false)
        binding.viewmodel = viewModel
        activity?.title = viewModel.getCardSetTitle()

        (activity as AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        editText.setOnEditorActionListener { _, i, _ ->
            when (i) {
                EditorInfo.IME_ACTION_GO -> viewModel.onClick()
            }
            true
        }

        viewModel.results.observe(this, Observer { string ->
            if (string != null && context != null) {
                val thisContext: Context = context as Context //todo: Clean up using contracts when kotlin 1.3 is out
                results.text = string
                results.setTextColor(ContextCompat.getColor(thisContext, when (string) {
                    "correct" -> R.color.correct_answer
                    else -> R.color.wrong_answer
                }))
                results.alpha = 1f
                results.animate()
                        .alpha(0f)
                        .setDuration(500)
                        .setStartDelay(2000)
                        .start()
            }
        })

        super.onViewCreated(view, savedInstanceState)
    }

}