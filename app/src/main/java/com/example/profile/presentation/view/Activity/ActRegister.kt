package com.example.profile.presentation.view.Activity

import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.profile.R
import com.example.profile.RegisterState
import com.example.profile.data.model.RegisterRequest
import com.example.profile.databinding.ActRegisterBinding
import com.example.profile.presentation.vm.DatePickerAlert
import com.example.profile.presentation.vm.RegisterViewModel
import kotlinx.coroutines.launch

class ActRegister : AppCompatActivity() {
    private lateinit var binding: ActRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnRegister.setOnClickListener {
            val validate = validateField()

            lifecycleScope.launch {
                if (validate) {
                    var data = RegisterRequest(
                        user = binding.etUser.text.toString(),
                        name = binding.etName.text.toString(),
                        lastName = "${binding.etMatern.text}",
                        secondLastName = "${binding.etPattern.text}",
                        birthday = binding.etDate.text.toString(),
                        email = binding.etEmail.text.toString(),
                        gender = binding.etSex.text.toString(),
                        state = binding.etState.text.toString(),
                        phone = binding.etNum.text.toString(),
                        passwor = binding.etPass.text.toString(),
                        civil = "soltero"
                    )
                    viewModel.register(data)
                }

                /*val database = DataBase(this@ActRegister).getDB()
                // database.daoUser().deleteUser()

                database.daoUser().insertUser(
                    UserRegister(
                        binding.etUser.text.toString(),
                        binding.etName.text.toString(),
                        binding.etMatern.text.toString(),
                        binding.etMatern.text.toString(),
                        binding.etDate.text.toString(),
                        binding.etEmail.text.toString(),
                        binding.etSex.text.toString(),
                        binding.etState.text.toString(),
                        binding.etNum.text.toString(),
                        binding.etPass.text.toString()
                    )
                )*/
                /*val users = database.daoUser().getUser()
                println(users)
                val name = database.daoUser().getName("root")
                println(name)*/
            }
        }

        binding.etDate.setOnClickListener {
            var date = DatePickerAlert(this)
            date.show(binding.etDate)
        }

        /*List Mediante xml*/
        binding.etState.setAdapter(
            ArrayAdapter(
                this,
                R.layout.item_option,
                resources.getStringArray(R.array.states)
            )
        )
        /*List mediante codigo*/
        var listGender = listOf("Masculino", "Femenino")
        binding.etSex.setAdapter(
            ArrayAdapter(
                this,
                R.layout.item_option,
                listGender
            )
        )
        viewModel.stateRegister.observe(this) {
            when (it) {
                is RegisterState.Cargando -> {
                    println("API: Cargando")
                }
                is RegisterState.Exitoso -> {
                    println("Api: Exitoso")
                }
                is RegisterState.Error -> {
                    println("Api: Error ${it.mensaje}")
                }
            }
        }
    }
    fun validateField(): Boolean {
        var band = false
        if (binding.etName.text.toString() == "") {
            band = false
            binding.inputName.error = getString(R.string.obligatori_field)
        } else {
            binding.inputName.setError(null)
        }
        if (binding.etPattern.text.toString() == "") {
            band = false
            binding.inputPaterno.error = getString(R.string.obligatori_field)
        } else {
            binding.inputPaterno.setError(null)
        }
        if (binding.etMatern.text.toString() == "") {
            band = false
            binding.inputMaterno.error = getString(R.string.obligatori_field)
        } else {
            binding.inputMaterno.setError(null)
        }
        if (binding.etDate.text.toString() == "") {
            band = false
            binding.inputDate.error = getString(R.string.obligatori_field)
        } else {
            binding.inputDate.setError(null)
        }
        if (binding.etSex.text.toString() == "") {
            band = false
            binding.inputSex.error = getString(R.string.obligatori_field)
        } else {
            binding.inputSex.setError(null)
        }
        if (binding.etEmail.text.toString() == "") {
            band = false // && Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()
            binding.inputEmail.error = getString(R.string.obligatori_field)
        } else if (Patterns.EMAIL_ADDRESS.matcher((binding.etEmail.text.toString())).matches()) {
            binding.inputEmail.setError(null)
        } else {
            binding.inputEmail.setError("Email Invalido")
        }
        if (binding.etState.text.toString() == "") {
            band = false
            binding.inputState.error = getString(R.string.obligatori_field)
        } else {
            binding.inputState.setError(null)
        }
        if (binding.etNum.text.toString() == "") {
            band = false
            binding.inputNum.error = getString(R.string.obligatori_field)
        } else {
            binding.inputNum.setError(null)
        }
        if (binding.etUser.text.toString() == "") {
            band = false
            binding.inputUser.error = getString(R.string.obligatori_field)
        } else {
            binding.inputState.setError(null)
        }
        if (binding.etPass.text.toString() == "") {
            band = false
            binding.inputpass.error = getString(R.string.obligatori_field)
        }
        if (binding.etPass1.text.toString() == "") {
            band = false
            binding.inputpass2.error = getString(R.string.obligatori_field)
        }
        if (binding.etPass1.text.toString() != "" && binding.etPass.text.toString() != "") {
            if (binding.etPass1.text.toString() != binding.etPass.text.toString()) {
                binding.inputpass2.setError("Contraseñas no coincide")
                band = false
            } else {
                binding.inputpass.setError(null)
                binding.inputpass2.setError(null)
            }
        }
        return band
    }
}
