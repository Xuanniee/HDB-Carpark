package com.xuannie.hdbcarpark.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.xuannie.hdbcarpark.R
import com.xuannie.hdbcarpark.ui.HdbCarparkScreen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    // States to store User Input for Login Information
    val userEmail = remember { mutableStateOf(TextFieldValue("")) }
    val userPassword = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .padding(20.dp)
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3
        )

        Spacer(modifier = modifier.height(20.dp))

        // Email Field
        Text(
            text = stringResource(R.string.login_email_text),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.h5
        )
        TextField(
            value = userEmail.value,
            onValueChange = {value ->
                userEmail.value = value
            },
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp),
            singleLine = true,
            // Search Icon at the Start for Aesthetics
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp)
                )
            },
            // Cancel Button to delete all Input
            trailingIcon = {
                if (userEmail.value != TextFieldValue("")) {
                    IconButton(onClick = {
                        userEmail.value = TextFieldValue("")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Delete all User Input",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            },
        )

        // Password Field
        Text(
            text = stringResource(R.string.login_pw_title),
            modifier = modifier,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.h5
        )
        TextField(
            value = userPassword.value,
            onValueChange = {value ->
                userPassword.value = value
            },
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp),
            singleLine = true,
            // Search Icon at the Start for Aesthetics
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Password,
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp)
                )
            },
            // Cancel Button to delete all Input
            trailingIcon = {
                if (userPassword.value != TextFieldValue("")) {
                    IconButton(onClick = {
                        userPassword.value = TextFieldValue("")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Delete all User Input",
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            },
//            colors = Color.Black,
        )

        // Login Button and Login with Singpass
        Row(
            modifier = modifier.weight(1f),
        ) {
            Button(onClick = {
                // Navigate to the Default Screen
                navController.navigate(HdbCarparkScreen.Default.name)
            }) {
                // Login Button
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.body2,
                    modifier = modifier
                        .padding(10.dp)
                        .weight(1f)
                )
            }

            Button(onClick = { /*TODO IF HAVE TIME*/ }) {
                // Singpass Login
                Image(
                    painter = painterResource(id = R.drawable.singpass_logo),
                    contentDescription = stringResource(R.string.singpass_login_desc),
                    modifier = modifier
                        .padding(10.dp)
                        .weight(1f)
                )

            }


        }

    }

}