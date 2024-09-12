package com.example.sharered

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.sharered.authentication.presentation.OnBoardingScreen
import com.example.sharered.ui.theme.ShareRedTheme
import com.example.sharered.utils.NavigationHelper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareRedTheme {
                val sharedPreferences = this.getSharedPreferences("Authentication", Context.MODE_PRIVATE)
                val navController = rememberNavController()
                NavigationHelper(navController, sharedPreferences)
            }
        }
    }
}