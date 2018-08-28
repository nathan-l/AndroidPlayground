package org.athaliapps.twilist.Utils

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.RecyclerView
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import org.athaliapps.models.Post
import org.athaliapps.twilist.ui.main.BaseAdapter
import org.athaliapps.twilist.ui.main.BindableAdapter
import org.athaliapps.twilist.ui.postsList.PostsListAdapter

@BindingAdapter("customOnClickCoroutine")
fun customOnClickCoroutine(btn: AppCompatButton, helper: CoroutineHelper) {
    btn.setOnClickListener {
        helper.job = launch(UI)
        {
            try {
                println("this is context ${kotlin.coroutines.experimental.coroutineContext}")
                btn.isEnabled = false
                withContext(CommonPool) {
                    helper.ayoh()
                }
                btn.isEnabled = true
            } catch (e: Exception) {
                println(e)
                btn.isEnabled = true
            }
        }
    }
}

@BindingAdapter("posts")
fun setPosts(recyclerView: RecyclerView, data: List<Post>) {
    val adapter = recyclerView.adapter ?: return

//    if (adapter is BaseAdapter<*, *>) {
//        adapter.setData(data)
//    }
    if(adapter is PostsListAdapter)
    {
        (recyclerView.adapter as PostsListAdapter).setData(data)
    }
}

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
    val adapter = recyclerView.adapter ?: return

    if (adapter is BindableAdapter<*>) {
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
    }
}
