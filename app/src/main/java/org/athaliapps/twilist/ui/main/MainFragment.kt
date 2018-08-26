package org.athaliapps.twilist.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.Contacts
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.athaliapps.twilist.R
import org.athaliapps.twilist.remote.JsonPlaceholderRemoteService

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        println("1")

        launch {
            println("2")
            val posts = JsonPlaceholderRemoteService.getPosts()
            println("3")

            launch(UI) {
                delay(100)
                println("4")
                message.text = posts.toString()
            }

            println("5")
        }

        println("6")
    }
}
