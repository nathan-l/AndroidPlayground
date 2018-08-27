package org.athaliapps.twilist.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request
import org.athaliapps.models.Post

class JsonPlaceholderRemoteService
{
    val baseUrl = "https://jsonplaceholder.typicode.com"
    val client = OkHttpClient()

    suspend fun getPosts() : List<Post>
    {
        try {
            val request = Request.Builder()
                    .url("$baseUrl/posts")
                    .build()

            val response = async { client.newCall(request).execute() }

            val body = response.await().body() ?: return listOf()
            val bodyString = body.string()

            val moshi = Moshi.Builder().build()
            val type = Types.newParameterizedType(List::class.java, Post::class.java)

            val jsonAdapter = moshi.adapter<List<Post>>(type)

            val posts = jsonAdapter.fromJson(bodyString)
            return posts ?: listOf()
        } catch (e: Exception) {
            println(e)
            return listOf()
        }
    }
}