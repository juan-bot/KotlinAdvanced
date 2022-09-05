package com.example.profile.presentation.view.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.profile.data.network.RetrofitClient
import com.example.profile.databinding.ActLoginBinding
import kotlinx.coroutines.launch

class ActLogin : AppCompatActivity() {
    private lateinit var binding: ActLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnLogin.setOnClickListener {
            lifecycleScope.launch {
                val response = RetrofitClient.api().getPokemon(1)
                println("Id: ${response.id}")
                println("Name: ${response.name}")
                println("Weight: ${response.weight}")
                println("Species: ${response.species.name}")
                for (i in 0..response.forms.size - 1) {
                    println("Form[$i].name: ${response.forms[i].name}")
                }
                for (i in 0..response.game.size - 1) {
                    println("game[$i].version.name: ${response.game[i].version.name}")
                }
                for (i in 0..response.moves.size - 1) {
                    for (j in 0..response.moves[i].version.size - 1)
                        println("moves[$i].version.learn.name: ${response.moves[i].version[j].learn.name}")
                }
            }
        }
    }
}
