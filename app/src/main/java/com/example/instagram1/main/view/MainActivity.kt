package com.example.instagram1.main.view

import android.annotation.SuppressLint
import android.graphics.Camera
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowInsetsController
import android.widget.Toolbar


import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.instagram1.R
import com.example.instagram1.camera.view.CameraFragment
import com.example.instagram1.databinding.ActivityMain2Binding
import com.example.instagram1.home.view.HomeFragment
import com.example.instagram1.profile.view.ProfileFragment
import com.example.instagram1.search.view.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener{

    private lateinit var binding: ActivityMain2Binding

    private lateinit var homeFragment: Fragment
    private lateinit var searchFragment: Fragment
    private lateinit var cameraFragment: Fragment
    private lateinit var profileFragment: Fragment
    private var currentFragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = ContextCompat.getColor(this, R.color.gray)
        }


        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_insta_camera)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        cameraFragment = CameraFragment()
        profileFragment = ProfileFragment()


        binding.mainBottomNav.setOnItemSelectedListener(this)
        binding.mainBottomNav.selectedItemId = R.id.menu_bottom_home


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

            when (item.itemId) {

                R.id.menu_bottom_home -> {
                    if (currentFragment == homeFragment) return false
                    currentFragment = homeFragment
                }

                R.id.menu_bottom_search -> {
                    if (currentFragment == searchFragment) return false
                    currentFragment = searchFragment
                }
                R.id.menu_bottom_add -> {
                    if (currentFragment == cameraFragment) return false
                    currentFragment = cameraFragment
                }
                R.id.menu_bottom_profile -> {
                    if (currentFragment == profileFragment) return false
                    currentFragment = profileFragment
                }
            }
            currentFragment?.let {

                if (supportFragmentManager.findFragmentById(R.id.main_fragment) == null) {
                    supportFragmentManager.beginTransaction().apply {
                        add(R.id.main_fragment, it)
                        addToBackStack(null)
                        commit()
                    }
                } else {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.main_fragment, it)
                        addToBackStack(null)
                        commit()
                    }
                }
            }

            return true
        }
    }
