package com.newcore.movieapptask.presintation

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.newcore.movieapptask.R
import com.newcore.movieapptask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as
                NavHostFragment).navController
    }
    private val appBarConfiguration by lazy {
        AppBarConfiguration(setOf(
            R.id.movieListFragment, R.id.movieDetailsFragment
        ))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        setupSmoothBottomMenu()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.menu_bottom_nav)
        val menu = popupMenu.menu
        binding.bottomNavigationView.setupWithNavController(menu, navController)
    }
}