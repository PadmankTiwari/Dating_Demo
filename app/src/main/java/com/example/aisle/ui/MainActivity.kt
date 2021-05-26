package com.example.aisle.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.aisle.R
import com.example.aisle.data.session.SessionManager
import com.example.aisle.databinding.ActivityMainBinding
import com.example.aisle.ui.base.BaseActivity
import com.example.aisle.utils.hideSoftInput
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
    }

    @Inject
    lateinit var sessionManager: SessionManager


    private val navController: NavController by lazy {
        Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)
        binding.bottomNavigation.getOrCreateBadge(R.id.matchesFragment).apply {
            backgroundColor = resources.getColor(R.color.purple_500)
            number = 50
        }
        binding.bottomNavigation.getOrCreateBadge(R.id.notesFragment).apply {
            backgroundColor = resources.getColor(R.color.purple_500)
            number = 9
        }
        lifecycleScope.launchWhenResumed {
            navController.addOnDestinationChangedListener { _, destination, _ ->
                onDestinationChange(destination)
            }
        }
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            handleNavigation(item)
        }
    }

    private fun handleNavigation(item: MenuItem): Boolean {
        return try {
            return if (navController.currentDestination?.id == item.itemId) {
                false
            } else {
                showAlert(getString(R.string.not_implemented))
                false
            }
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    private fun onDestinationChange(destination: NavDestination) {
        hideSoftInput()
        val config = PageConfiguration.getConfiguration(destination.id)
        if (config.bottomNavigationBarVisible) {
            binding.bottomNavigation.visibility = View.VISIBLE
        } else {
            binding.bottomNavigation.visibility = View.INVISIBLE
        }
    }
}