package com.example.profile.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.profile.R
import com.example.profile.databinding.FrgHomeBinding

class FrgHome : Fragment() {
    private lateinit var binding: FrgHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn1.setOnClickListener {
            findNavController().navigate(R.id.toFrgProfile)
        }
        binding.btn2.setOnClickListener {
            findNavController().navigate(R.id.toFrgContentProfile)
        }
        binding.btn3.setOnClickListener {
            findNavController().navigate(R.id.toFrgAbout)
        }
    }
}
/*
class ExampleFragment : Fragment(R.layout.example_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")
        ...
    }
}*/
