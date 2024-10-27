package com.example.challengearena


import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.Auth ,R.id.Login ->
                    bottomNav.visibility = View.GONE
                else -> bottomNav.visibility = View.VISIBLE
            }

        }

        bottomNav.setOnItemSelectedListener  { item ->
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            when (item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.action_to_Home)
                    true
                }
                R.id.profile -> {
//                    Log.d("mLogClcl","я тут!!")
                    navController.navigate(R.id.action_to_Profile)
                    true
                }
                R.id.challendes ->{
                    navController.navigate(R.id.action_to_Challenges)

                    true
                }

                else -> false
            }
        }

    }
}