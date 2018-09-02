package com.mscottmcbee.flashkana.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mscottmcbee.flashkana.BuildConfig
import com.mscottmcbee.flashkana.R

import com.mscottmcbee.flashkana.databinding.FragmentMainBinding
import com.mscottmcbee.flashkana.model.dataobjects.CardSet
import com.mscottmcbee.flashkana.ui.main.recycler.CardSetRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    var viewModel: MainViewModel? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var binding: FragmentMainBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        viewModel = getViewModel()
        binding.viewmodel = viewModel

        activity?.title = "FlashKana" + BuildConfig.APPLICATION_ID.substring(25)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var mainAdapter = CardSetRecyclerAdapter(ArrayList())
        recyclerview_main.layoutManager = LinearLayoutManager(activity)
        recyclerview_main.adapter = mainAdapter
        progressbar_main.visibility = View.VISIBLE

        val postListObserver = Observer<HashMap<String, CardSet>> { cardSets ->
            mainAdapter.data = cardSets.values.toList().sortedBy { it -> it.id }
            mainAdapter.notifyDataSetChanged()
            if (!cardSets.values.toList().isEmpty()) {
                progressbar_main.visibility = View.GONE
            }
        }

        viewModel?.getCardSets()?.observe(this, postListObserver)
    }
}