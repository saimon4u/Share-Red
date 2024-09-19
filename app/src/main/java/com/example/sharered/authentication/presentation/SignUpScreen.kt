package com.example.sharered.authentication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sharered.authentication.presentation.components.AuthBox
import com.example.sharered.authentication.presentation.components.AuthHeader

@Composable
fun SignUpScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ){
        AuthHeader()
        Spacer(modifier = Modifier.height(32.dp))
        AuthBox(isSignIn = false, navController = navController)
    }
}