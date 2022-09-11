package com.example.profile.presentation.view.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.profile.LoginState
import com.example.profile.R
import com.example.profile.data.model.LoginRequest
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
            println("Dios : ${binding.etName.text}")
            println("Dios : ${binding.etName.text}")
            // consumo de api
            var data = LoginRequest(
                user = binding.etName.text.toString(),
                pass = binding.etPass.text.toString()
            )
            viewModel.login(data)
        }
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, ActRegister::class.java).apply {
                putExtra("aver", binding.etName.text.toString())
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
                    val intent = Intent(this, ActDashboard::class.java).apply {
                        putExtra("mmm", binding.etName.text.toString().trim())
                    }
                    startActivity(intent)
                }
                is LoginState.Error -> {
                    println("Api: Error ${it.mensaje}")
                }
            }
        }
    }
}
