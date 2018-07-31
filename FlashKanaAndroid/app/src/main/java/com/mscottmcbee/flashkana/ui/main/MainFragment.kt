package com.mscottmcbee.flashkana.ui.main


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mscottmcbee.flashkana.R
import com.mscottmcbee.flashkana.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        //https://stackoverflow.com/questions/9245408/best-practice-for-instantiating-a-new-android-fragment/9245510#9245510
        fun newInstance(): MainFragment {
            val mainFragment = MainFragment()
            return mainFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var viewModel = MainViewModel()

        var binding: FragmentMainBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main,container,false)
        binding.viewmodel = viewModel

        activity?.title = "FLAShKANa"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainAdapter = KanaSetRecyclerAdapter()
        //mainAdapter.setMainRecyclerInterface(presenter.getRecyclerHandler())
        (recyclerview_main as RecyclerView).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mainAdapter

           // presenter.setup()
        }
    }
/*
    override fun onFlashCardSetClicked(id: Int) {
        val intent = Intent(context, KanaViewFragment::class.java)
        intent.putExtra(KanaViewFragment.Model_ID, id)
        startActivity(intent)
    }

    override fun onFlashQuizSetClicked(id: Int) {
        val intent = Intent(context, KanaQuizActivity::class.java)
        intent.putExtra(KanaViewFragment.Model_ID, id)
        startActivity(intent)
    }

    override fun onFlashSetMoreClicked(id: Int) {
        val intent = Intent(context, StatsActivity::class.java)
        intent.putExtra(KanaViewFragment.Model_ID, id)
        startActivity(intent)
    }
*/
}