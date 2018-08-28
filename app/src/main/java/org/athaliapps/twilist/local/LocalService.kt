package org.athaliapps.twilist.local

import kotlinx.coroutines.experimental.delay
import org.athaliapps.models.Post

class LocalService()
{
    var posts: List<Post> = listOf()

    suspend fun aer()
    {
        delay(21)
    }
    var postsmap = posts.map { it.id to it }.toMap()
}
