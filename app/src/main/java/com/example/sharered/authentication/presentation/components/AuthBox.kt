package com.example.sharered.authentication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.sharered.R
import com.example.sharered.authentication.presentation.AuthEvent
import com.example.sharered.authentication.presentation.AuthenticationViewModel
import com.example.sharered.utils.Screen

@Composable
fun AuthBox(
    modifier: Modifier = Modifier,
    isSignIn: Boolean,
    navController: NavHostController
) {
    val viewModel = hiltViewModel<AuthenticationViewModel>()
    val state = viewModel.authState.collectAsStateWithLifecycle().value
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.surfaceDim
        )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AuthToggleButton(
                isSignIn = isSignIn,
                onSignInClick = {
                    viewModel.onEvent(AuthEvent.NavigateTo(Screen.SignInScreen))
                    navController.popBackStack()
                    navController.navigate(Screen.SignInScreen)
                },
                onSignUpClick = {
                    viewModel.onEvent(AuthEvent.NavigateTo(Screen.SignUpScreen))
                    navController.popBackStack()
                    navController.navigate(Screen.SignUpScreen)
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = if(state.currentScreen is Screen.SignInScreen) state.signInEmail else state.signUpEmail,
                onValueChange = {
                    if(state.currentScreen is Screen.SignInScreen) viewModel.onEvent(AuthEvent.EnteredSignInEmail(it))
                    else viewModel.onEvent(AuthEvent.EnteredSignUpEmail(it))
                },
                singleLine = true,
                label = { Text(text = "Email")},
                colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                placeholder = { Text(text = "Enter your email")}
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = if(state.currentScreen is Screen.SignInScreen) state.signInPassword else state.signUpPassword,
                onValueChange = {
                    if(state.currentScreen is Screen.SignInScreen) viewModel.onEvent(AuthEvent.EnteredSignInPassword(it))
                    else viewModel.onEvent(AuthEvent.EnteredSignUpPassword(it))
                },
                singleLine = true,
                label = { Text(text = "Password")},
                colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onBackground),
                placeholder = { Text(text = "Enter your password")},
                trailingIcon = { Icon(imageVector = Icons.Default.Visibility, contentDescription = null)}
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                if(!isSignIn) Icon(imageVector = Icons.Default.CheckBoxOutlineBlank, contentDescription = null, modifier = Modifier.size(20.dp))
                Text(
                    text = if(isSignIn) "Forgot password" else "Remember me",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = if(isSignIn) "Sign In" else "Sign Up",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "-or-",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.facebook), contentDescription = null)
                }
                Spacer(modifier = Modifier.width(5.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.google), contentDescription = null)
                }
                Spacer(modifier = Modifier.width(5.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.github), contentDescription = null)
                }
            }
        }
    }
}
