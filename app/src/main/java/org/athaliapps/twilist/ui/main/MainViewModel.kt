package org.athaliapps.twilist.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import android.view.View
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import org.athaliapps.models.Post
import org.athaliapps.twilist.Utils.CoroutineHelper
import org.athaliapps.twilist.local.LocalService
import org.athaliapps.twilist.remote.JsonPlaceholderRemoteService
import org.athaliapps.twilist.repository.PostRepository

class MainViewModel : ViewModel() {

    val text : MutableLiveData<String> = MutableLiveData()
    private val stringBuilder = StringBuilder()
    var onButtonClickHelper = CoroutineHelper({ loadPosts() })

    var posts : MutableLiveData<List<Post>> = MutableLiveData()
    private set(value) {
        field = value
    }

    init {
        val testPost = Post(123,456,"title", "ojeroweriworiweoirnwoeinr")
        posts.value = listOf(testPost)
    }

    fun cancelLoad(v: View)
    {
        onButtonClickHelper.job?.cancel()
    }

    private suspend fun loadPosts() {
        launch(UI){
            posts.value = PostRepository(JsonPlaceholderRemoteService(), LocalService()).GetAndRefreshPosts()
        }
    }
}
