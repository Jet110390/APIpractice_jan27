package com.example.apipractice_jan27.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipractice_jan27.databinding.FragmentTodoBinding
import com.example.apipractice_jan27.model.network.ApiManager
import com.example.apipractice_jan27.model.network.models.Todo
import com.example.apipractice_jan27.model.repository.TodoRepository
import com.example.apipractice_jan27.viewmodel.TodoViewModel

class TodoFragment: Fragment() {

    private var _binding : FragmentTodoBinding? = null
    private val binding : FragmentTodoBinding get() = _binding!!

    private val viewModel: TodoViewModel by activityViewModels {
        TodoViewModel.Factory(TodoRepository(ApiManager()))
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.todos.observe(viewLifecycleOwner){
//            binding.todoTv.text = it.toString()
//        }
        with(binding) {
            viewModel.todos.observe(viewLifecycleOwner) {todo->

                todoRv.apply {
                    adapter = TodoAdapter(todo as MutableList<Todo>)
                    layoutManager =
                        LinearLayoutManager(requireContext())
                }
            }
            backBtn.setOnClickListener {
                val directions =
                    TodoFragmentDirections.actionTodoFragmentToStartFragment()
                findNavController().navigate(directions)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}