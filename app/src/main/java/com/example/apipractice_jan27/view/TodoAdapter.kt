package com.example.apipractice_jan27.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apipractice_jan27.databinding.TodoItemBinding
import com.example.apipractice_jan27.model.network.models.Todo
import java.lang.Integer.parseInt

class TodoAdapter(
    private val todoList: MutableList<Todo> = mutableListOf<Todo>()
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(inflater,parent,false)
        return TodoViewHolder(binding)
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
    class TodoViewHolder(private val binding: TodoItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo) {
            with(binding) {
                userIdTv.text  = "${todo.userId}"
                idTv.text = "${todo.id}"
                titleTv.text = todo.title
                bodyTv.text = todo.body
            }

        }
    }
}