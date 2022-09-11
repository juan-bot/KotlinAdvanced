package com.example.profile.presentation.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.profile.data.local.sp.LoginDataModel

class LoginShPrefViewModel(context: Context) : ViewModel() {
    var usuario = MutableLiveData<String>()
    val SharedPreferences = context.getSharedPreferences("df", Context.MODE_PRIVATE)
    val editor = SharedPreferences.edit()

    fun setInfo(data: LoginDataModel) {
        editor.putString("user", data.user)
        editor.putString("password", data.password)
        editor.apply()
        editor.commit()
    }
}
