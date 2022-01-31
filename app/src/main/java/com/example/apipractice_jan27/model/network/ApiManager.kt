package com.example.apipractice_jan27.model.network

class ApiManager {

    private var todoService: TodoService =
        RetrofitInstance.providesRetrofit().create(TodoService::class.java)

    suspend fun getTodos() = todoService.getTodos()
}