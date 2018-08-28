package org.athaliapps.models

data class Post(
        val id: Int,
        val userId: Int,
        var title: String,
        var body: String
        )