package com.example.apipractice_jan27.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apipractice_jan27.databinding.FragmentStartPageBinding

class StartFragment: Fragment() {

    private var _binding : FragmentStartPageBinding? = null
    private val binding: FragmentStartPageBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding= FragmentStartPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
                    startBtn.setOnClickListener {
                        val directions =
                            StartFragmentDirections.actionStartFragmentToTodoFragment()
                        findNavController().navigate(directions)
                    }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}