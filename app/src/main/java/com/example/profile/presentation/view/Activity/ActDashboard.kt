package com.example.profile.presentation.view.Activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import com.example.profile.R
import com.example.profile.databinding.ActDashboardBinding
import com.example.profile.presentation.vm.GetInfViewModel
import com.google.android.material.navigation.NavigationView

class ActDashboard : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActDashboardBinding
    private lateinit var actionBatDrawerToggle: ActionBarDrawerToggle
    private val viewModel: GetInfViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("mmm").toString()
        viewModel.getInfo(name)
        viewModel.stateInfo.observe(this) {
            val tvName: TextView = findViewById(R.id.tvName)
            val tvEmail: TextView = findViewById(R.id.tvEmail)
            tvName.setText(it.user.name)
            tvEmail.setText(it.user.email)
        }
        setNavigationView()
        setDrawerLayout()
    }

    private fun setNavigationView() {
        val navigationView = findViewById<View>(R.id.navView) as NavigationView
        val viewHeader: View = LayoutInflater.from(this)
            .inflate(R.layout.header, navigationView, false)
        navigationView.addHeaderView(viewHeader)
    }
    private fun setDrawerLayout() {
        setSupportActionBar(binding.topAppBar)
        actionBatDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        // abre y cierra al presionar el boton
        actionBatDrawerToggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBatDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_profile -> {
                println("profile")
                Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.frgProfile)
            }
            R.id.menu_content -> {
                println("content")
                Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.frgContentProfile)
            }
            R.id.menu_about -> {
                println("about")
                Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.frgAbout)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }
}
