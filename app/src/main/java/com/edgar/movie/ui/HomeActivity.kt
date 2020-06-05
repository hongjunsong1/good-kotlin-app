package com.edgar.movie.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.edgar.movie.R
import com.google.android.material.bottomnavigation.BottomNavigationView
class HomeActivity : AppCompatActivity() {

    var TAG = "HomeActivity"
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.elevation = 2.0f

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_movie,
                R.id.navigation_rank,
                R.id.navigation_cinema,
                R.id.navigation_my
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.getOrCreateBadge(R.id.navigation_movie)?.number = 2
        navView.setOnNavigationItemReselectedListener { it: MenuItem -> Log.e(TAG, "OnNavigationItemReselected:" + it.title)}
        navView.setOnNavigationItemSelectedListener { item ->
            Log.e(TAG, "OnNavigationItemSelected:" + item.title)
            true
        }

    }
}