package com.example.sharered.authentication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sharered.R

@Composable
fun AuthHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(
                RoundedCornerShape(
                    bottomStart = 100.dp,
                    bottomEnd = 100.dp
                )
            )
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 100.dp,
                        bottomEnd = 100.dp
                    )
                )
                .alpha(.75f)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 100.dp,
                        bottomEnd = 100.dp
                    )
                )
            ,
            painter = painterResource(id = R.drawable.handshake),
            contentDescription = null
        )
        Text(
            text = "Share Red",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
        )
    }
}

