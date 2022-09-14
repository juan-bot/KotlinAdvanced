package com.example.profile.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.profile.R
import com.example.profile.databinding.FrgAboutBBinding

class FrgAboutB : Fragment() {
    private lateinit var binding: FrgAboutBBinding
    private val argsFromA: FrgAboutBArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAboutBBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("arg 1: ${argsFromA.argFromA}")
        println("arg 2: ${argsFromA.argFromA2}")
        binding.btnToC.setOnClickListener {
            val actionWithParametes = FrgAboutBDirections.toFrgAboutC("Args from B", 21, true)
            findNavController().navigate(actionWithParametes)
        }
    }
}
