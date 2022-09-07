package com.example.profile.presentation.view.Activity

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.profile.LoginState
import com.example.profile.R
import com.example.profile.databinding.ActLoginBinding
import com.example.profile.presentation.vm.LoginViewModel

class ActLogin : AppCompatActivity() {
    private lateinit var binding: ActLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnLogin.setOnClickListener {
            if (binding.etName.text.toString() != "") {
                binding.inputName.setError(null)
            } else {
                binding.inputName.error = getString(R.string.obligatori_field)
            }
            if (binding.etPass.text.toString() != "") {
                binding.inputPassword.setError(null)
            } else {
                binding.inputPassword.error = getString(R.string.obligatori_field)
            }
            /*var data = LoginRequest(
                    name = binding.etName.text.toString(),
                    pass = binding.etPass.text.toString()
                )
                viewModel.login(data)

                lifecycleScope.launch {
                    val responseLogin = RetrofitClient.api().login(data)
                    println("Respuesta: $responseLogin")
                } */

            /*lifecycleScope.launch {
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
            }*/
        }
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, ActRegister::class.java).apply {
                putExtra(EXTRA_MESSAGE, "message")
            }
            startActivity(intent)
        }
        viewModel.stateLogin.observe(this) {
            when (it) {
                is LoginState.Cargando -> {
                    println("API: Cargando")
                }
                is LoginState.Exitoso -> {
                    println("Api: Exitoso")
                }
                is LoginState.Error -> {
                    println("Api: Error ${it.mensaje}")
                }
            }
        }
    }
}
