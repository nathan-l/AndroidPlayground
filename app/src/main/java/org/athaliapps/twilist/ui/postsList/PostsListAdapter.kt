package org.athaliapps.twilist.ui.postsList

import android.support.v7.util.DiffUtil
import org.athaliapps.models.Post
import org.athaliapps.twilist.R
import org.athaliapps.twilist.ui.main.BindableAdapter
import org.athaliapps.twilist.ui.main.GenericListAdapter

class PostsListAdapter : GenericListAdapter<Post>(DiffCallback()), BindableAdapter<List<Post>> {
    override fun setData(data: List<Post>) {
        this.submitList(data)
    }

    class DiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(p0: Post, p1: Post): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun areContentsTheSame(p0: Post, p1: Post): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun getItemViewType(position: Int) = R.layout.post_list_item_template

}