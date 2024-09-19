package com.example.sharered.authentication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sharered.utils.Screen

@Composable
fun AuthToggleButton(
    modifier: Modifier = Modifier,
    isSignIn: Boolean,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    if (isSignIn) MaterialTheme.colorScheme.secondary
                    else Color.Transparent
                )
                .padding(vertical = 5.dp)
                .clickable {onSignInClick()},
            text = "Sign In",
            style = MaterialTheme.typography.bodyMedium,
            color = if(isSignIn) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    if (!isSignIn) MaterialTheme.colorScheme.secondary
                    else Color.Transparent
                )
                .padding(vertical = 5.dp)
                .clickable {onSignUpClick()},
            text = "Sign Up",
            style = MaterialTheme.typography.bodyMedium,
            color = if(!isSignIn) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onSecondaryContainer,
            textAlign = TextAlign.Center
        )
    }
}