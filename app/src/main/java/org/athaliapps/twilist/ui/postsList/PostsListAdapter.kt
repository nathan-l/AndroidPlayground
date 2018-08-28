package org.athaliapps.twilist.ui.postsList

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.athaliapps.models.Post
import org.athaliapps.twilist.R
import org.athaliapps.twilist.databinding.PostListItemTemplateBinding
import org.athaliapps.twilist.ui.main.BaseAdapter
import org.athaliapps.twilist.ui.main.BindableAdapter

class PostsListAdapter : RecyclerView.Adapter<PostsListAdapter.PostViewHolder>(), BindableAdapter<List<Post>>{
    override fun setData(data: List<Post>) {
        postsList = data
        notifyDataSetChanged()
    }

    private var postsList: List<Post> = listOf()

    override fun getItemCount() = postsList.count()

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postsList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding: PostListItemTemplateBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
                , R.layout.post_list_item_template, parent, false)
        return PostViewHolder(binding)
    }

    class PostViewHolder(private val binding: PostListItemTemplateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(p: Post) {
            binding.post = p
            binding.executePendingBindings()
        }
    }
}