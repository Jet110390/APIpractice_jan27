package com.example.apipractice_jan27.model.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
