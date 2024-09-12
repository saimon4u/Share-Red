package com.example.sharered.utils

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sharered.authentication.presentation.OnBoardingScreen
import com.example.sharered.authentication.presentation.SignInScreen
import com.example.sharered.authentication.presentation.SplashScreen

@Composable
fun NavigationHelper(
    navController: NavHostController,
    pref: SharedPreferences
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen
    ){
        composable<Screen.SplashScreen>{
            SplashScreen(
                navController = navController,
                pref = pref
            )
        }
        composable<Screen.OnBoardingScreen> {
            OnBoardingScreen(navController = navController)
        }
        composable<Screen.SignInScreen>{
            SignInScreen()
        }
    }
}