package org.athaliapps.twilist.repository

import org.athaliapps.models.Post
import org.athaliapps.twilist.local.LocalService
import org.athaliapps.twilist.remote.JsonPlaceholderRemoteService

class PostRepository(private val remoteService: JsonPlaceholderRemoteService, private val localService: LocalService) {

    suspend fun GetAndRefreshPosts(): List<Post>
    {
        val remotePosts = remoteService.getPosts()
        localService.posts = remotePosts
        return localService.posts
    }

    fun GetPosts() = localService.posts

    fun GetPost(id: Int): Post?
    {
        return localService.postsmap[id]
    }
}