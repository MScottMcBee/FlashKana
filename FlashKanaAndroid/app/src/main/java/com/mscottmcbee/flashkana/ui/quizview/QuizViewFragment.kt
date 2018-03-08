package com.mscottmcbee.flashkana.ui.quizview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.model.KanaObject
import kotlinx.android.synthetic.main.fragment_quiz_view.*

class QuizViewFragment : Fragment(), QuizViewContract.View {

    override lateinit var presenter: QuizViewContract.Presenter

    companion object {
        fun newInstance(): QuizViewFragment {
            return QuizViewFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.fragment_quiz_view, container, false)!!
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_quiz_view_answer1.setOnClickListener { _ ->
            presenter.onAnswerClicked(0)
        }
        fragment_quiz_view_answer2.setOnClickListener { _ ->
            presenter.onAnswerClicked(1)
        }
        fragment_quiz_view_answer3.setOnClickListener { _ ->
            presenter.onAnswerClicked(2)
        }
        fragment_quiz_view_answer4.setOnClickListener { _ ->
            presenter.onAnswerClicked(3)
        }

        presenter.setup()
    }

    override fun showKana(kanaObject: KanaObject) {
        fragment_quiz_view_glyph.text = kanaObject.glyph
    }

    override fun showAnswer(answer: String, index: Int) {
        when (index) {
            0 -> fragment_quiz_view_answer1.text = answer
            1 -> fragment_quiz_view_answer2.text = answer
            2 -> fragment_quiz_view_answer3.text = answer
            3 -> fragment_quiz_view_answer4.text = answer
        }
    }
}