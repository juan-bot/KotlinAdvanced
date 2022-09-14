package com.example.profile.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.profile.R
import com.example.profile.databinding.FrgAboutCBinding

class FrgAboutC : Fragment() {
    private lateinit var binding: FrgAboutCBinding
    private val argsFromB: FrgAboutCArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgAboutCBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("arg 1: ${argsFromB.argFromB1}")
        println("arg 2: ${argsFromB.argFromB2}")
        println("arg 3: ${argsFromB.argFromB3}")
        binding.btnToA.setOnClickListener {
            findNavController().navigate(R.id.toFrgAbout)
        }
    }
}
