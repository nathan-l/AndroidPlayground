package org.athaliapps.twilist.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.athaliapps.twilist.R
import org.athaliapps.twilist.databinding.MainFragmentBinding
import org.athaliapps.twilist.ui.postsList.PostsListAdapter

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val binding = DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false)
        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)
        binding.postsRecyclerView.adapter = PostsListAdapter()
        binding.postsRecyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}
