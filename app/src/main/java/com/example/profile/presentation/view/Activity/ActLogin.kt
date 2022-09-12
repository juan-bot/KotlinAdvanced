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
            if (valida()) {
                // room
                /*lifecycleScope.launch {
                    val database = DataBase(this@ActLogin).getDB()
                    val response = database.daoUser().getUser(binding.etName.text.toString(), binding.etPass.text.toString())
                    if (response != null) {
                        println("existee")
                    } else {
                        println("No esta :(")
                    }
                }*/
                // consumo de api
                var data = LoginRequest(
                    user = binding.etName.text.toString(),
                    pass = binding.etPass.text.toString()
                )
                viewModel.login(data, this)
            }
        }
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, ActRegister::class.java).apply {
            }
            startActivity(intent)
        }
        viewModel.stateLogin.observe(this) {
            when (it) {
                is LoginState.Cargando -> {
                    println("API: Cargando")
                }
                is LoginState.Exitoso -> {
                    // println("${LoginState.Exitoso}")
                    val intent = Intent(this, ActDashboard::class.java).apply {
                        putExtra("user", binding.etName.text.toString())
                        putExtra("pass", binding.etPass.text.toString())
                    }
                    startActivity(intent)
                }
                is LoginState.Error -> {
                    println("Error ${it.mensaje}")
                    binding.inputName.setError("Usuario o contraseña incorrecto")
                    binding.inputPassword.setError("Usuario o contraseña incorrecto")
                }
            }
        }
    }
    private fun valida(): Boolean {
        var ban = true
        if (binding.etName.text.toString() != "") {
            binding.inputName.setError(null)
        } else {
            ban = false
            binding.inputName.error = getString(R.string.obligatori_field)
        }
        if (binding.etPass.text.toString() != "") {
            binding.inputPassword.setError(null)
        } else {
            ban = false
            binding.inputPassword.error = getString(R.string.obligatori_field)
        }
        return ban
    }
}
