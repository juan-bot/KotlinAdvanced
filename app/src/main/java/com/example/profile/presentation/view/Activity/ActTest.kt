package com.example.profile.presentation.view.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.profile.R
import com.example.profile.databinding.ActivityActTestBinding
import com.example.profile.presentation.view.fragment.HomeFragment
import com.example.profile.presentation.view.fragment.NotificationFragment
import com.example.profile.presentation.view.fragment.PerfilFragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActTest : AppCompatActivity() {
    private lateinit var binding: ActivityActTestBinding
    private lateinit var bottonNav: BottomNavigationView
    private lateinit var toolbar: MaterialToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = binding.materialToolbar
        toolbar.setTitle(R.string.app_name)
        bottonNav = binding.BtnNav
        changeFragment(HomeFragment())
        bottonNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> changeFragment(HomeFragment())
                R.id.notification -> changeFragment(NotificationFragment())
                R.id.perfil -> changeFragment(PerfilFragment())
                else -> {
                    changeFragment(HomeFragment())
                }
            }
            true
        }
    }
    fun changeFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaccion: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaccion.replace(R.id.butomnavigation, fragment)
        fragmentTransaccion.commit()
    }
}
