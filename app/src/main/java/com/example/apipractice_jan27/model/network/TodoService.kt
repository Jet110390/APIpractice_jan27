package com.example.apipractice_jan27.model.network

import com.example.apipractice_jan27.model.network.models.Todo
import retrofit2.Response
import retrofit2.http.GET

interface TodoService {

    @GET("posts")
    suspend fun getTodos(): Response<List<Todo>>

}