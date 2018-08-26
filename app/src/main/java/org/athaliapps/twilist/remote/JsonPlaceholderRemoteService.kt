package org.athaliapps.twilist.remote

import kotlinx.coroutines.experimental.Deferred
import okhttp3.OkHttpClient
import okhttp3.Request

class JsonPlaceholderRemoteService
{
    val baseUrl = "https://jsonplaceholder.typicode.com"
    val client = OkHttpClient()

    fun getPosts() : Deferred<List<Post>>
    {
        val request = Request.Builder()
                .url("$baseUrl/posts")
                .build()

        val response = client.newCall(request).execute()
        val body = response.body()
        println(body)
    }
}