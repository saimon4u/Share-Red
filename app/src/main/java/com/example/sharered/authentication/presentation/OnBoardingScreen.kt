package com.example.sharered.authentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.sharered.R
import com.example.sharered.utils.Screen
import com.example.sharered.ui.theme.babyPink

@Composable
fun OnBoardingScreen(
    navController: NavController
) {
    val donor by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.blood))
    val recipient by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.blood))
    var isDonorPlaying by remember { mutableStateOf(false) }
    var isRecipientPlaying by remember { mutableStateOf(false) }
    val donorProgress by animateLottieCompositionAsState(
        composition = donor,
        isPlaying = isDonorPlaying
    )
    val recipientProgress by animateLottieCompositionAsState(
        composition = recipient,
        isPlaying = isRecipientPlaying
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(babyPink)
            .padding(16.dp),
    ) {
        Heading()
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.donate),
                contentDescription = "Donate Icon",
                modifier = Modifier
                    .size(150.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "What do you want?",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Column(
                    modifier = Modifier
                        .clickable {
                            if(!isRecipientPlaying) isDonorPlaying = true
                            navController.navigate(Screen.SignInScreen)
                        }
                ){
                    LottieAnimation(
                        composition = donor,
                        modifier = Modifier.size(120.dp),
                        progress = {donorProgress}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Be a donor",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                }
                Column(
                    modifier = Modifier
                        .clickable {
                            if(!isDonorPlaying) isRecipientPlaying = true
                            navController.navigate(Screen.RequestScreen)
                        }
                ) {
                    LottieAnimation(
                        composition = recipient,
                        modifier = Modifier.size(120.dp),
                        progress = {recipientProgress}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Request blood",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Composable
private fun Heading() {
    Text(
        text = "Everyone Could Be A Hero",
        style = MaterialTheme.typography.headlineLarge,
        color = Color.Black,
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Saving lives, spreading smiles🤝",
        style = MaterialTheme.typography.bodySmall,
        color = Color.Black,
    )
}