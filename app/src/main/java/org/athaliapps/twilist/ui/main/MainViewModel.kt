package org.athaliapps.twilist.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v7.widget.AppCompatButton
import android.view.View
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import org.athaliapps.twilist.local.LocalService
import org.athaliapps.twilist.remote.JsonPlaceholderRemoteService
import org.athaliapps.twilist.repository.PostRepository
import java.util.*

class MainViewModel : ViewModel() {

    var text : MutableLiveData<String> = MutableLiveData()
    private val stringBuilder = StringBuilder()

    fun onButtonClicked(view: View) {
      doStuff()
    }

    fun onButtonClickedCustom () {
        println("custom!d")
        doStuff()
    }

    private fun doStuff() = launch(UI) {
        delay(2000)
        println("hoy!")
        text.value = "lalala " + Random().nextInt()
    }

    private suspend fun LoadPosts()
    {
        val posts1 = PostRepository(JsonPlaceholderRemoteService(), LocalService()).GetAndRefreshPosts()

        val test = posts1.map { it.id to it }
        val posts = posts1 + posts1 + posts1 + posts1
        println(test)

        launch(UI) {
            posts.forEach { stringBuilder.append("${it.title}\n") }
            text.value = stringBuilder.toString()
        }
    }
}
