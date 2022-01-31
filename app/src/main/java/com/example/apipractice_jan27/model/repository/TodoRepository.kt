package com.example.apipractice_jan27.model.repository

import com.example.apipractice_jan27.model.network.ApiManager
import com.example.apipractice_jan27.model.network.models.Todo
import java.lang.Exception

class TodoRepository(
    private val apiManager: ApiManager
) {
    suspend fun getTodos(): List<Todo>? {
        return try {
            val response = apiManager.getTodos()
            if (response.isSuccessful){
                response.body()
            }else {
                emptyList()
            }
        }catch (ex: Exception) {
            emptyList()
        }
    }
}