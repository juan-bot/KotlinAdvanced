package com.example.profile.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.profile.R
import com.example.profile.databinding.FrgToolbarBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class FrgToolbar : Fragment() {
    private lateinit var binding: FrgToolbarBinding
    private lateinit var bottonNav: BottomNavigationView
    private lateinit var toolbar: MaterialToolbar

    fun changeFragment(fragment: Fragment) {
        val fragmentManager = getParentFragmentManager()
        val fragmentTransaccion: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaccion.replace(R.id.butomnavigation, fragment)
        fragmentTransaccion.commit()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgToolbarBinding.inflate(inflater, container, false)
        return binding.root
    }
}
