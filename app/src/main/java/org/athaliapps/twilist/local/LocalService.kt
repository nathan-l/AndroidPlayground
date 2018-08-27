package org.athaliapps.twilist.local

import org.athaliapps.models.Post

class LocalService()
{
    var posts: List<Post> = listOf()

    var postsmap = posts.map { it.id to it }.toMap()
}
