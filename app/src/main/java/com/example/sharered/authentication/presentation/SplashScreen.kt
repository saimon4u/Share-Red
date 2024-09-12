package com.example.sharered.authentication.presentation

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.sharered.R
import com.example.sharered.utils.ConnectivityObserver
import com.example.sharered.utils.NetworkConnectivityObserver
import com.example.sharered.utils.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    pref: SharedPreferences,
    navController: NavController
){
    val context = LocalContext.current
    val connectivityObserver = NetworkConnectivityObserver(context)
    val status by connectivityObserver.observe().collectAsState(
        initial = ConnectivityObserver.Status.Unavailable
    )
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_animation))
    var isPlaying by remember { mutableStateOf(true) }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying
    )
    var animationCount by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = progress) {
        if(progress == 0f) isPlaying = true
        if(progress == 1f) isPlaying = false
    }
    LaunchedEffect(key1 = isPlaying) {
        if(!isPlaying && animationCount < 3) {
            isPlaying = true
            animationCount++
        }
    }

    LaunchedEffect(key1 = status) {
        delay(4000)
        if(status == ConnectivityObserver.Status.Available){
            val isAuthenticated = pref.getBoolean("authenticated", false)
            if(isAuthenticated) navController.navigate(Screen.HomeScreen)
            else navController.navigate(Screen.OnBoardingScreen)
        }else{
            Toast.makeText(context, "Please check your internet...", Toast.LENGTH_LONG).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        if(animationCount == 3 && !isPlaying){
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(200.dp)
            )
        }else{
            LottieAnimation(
                composition = composition,
                modifier = Modifier.size(200.dp),
                progress = {progress}
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Share Red",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}