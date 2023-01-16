package com.xuannie.hdbcarpark.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
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
    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }
    val focusManager = LocalFocusManager.current

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
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                .height(56.dp),
            singleLine = true,
            // Search Icon at the Start for Aesthetics
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp),
                    tint = Color.Black
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
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
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
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = modifier
                .fillMaxWidth()
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
                .height(56.dp),
            singleLine = true,
            // Search Icon at the Start for Aesthetics
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Password,
                    contentDescription = null,
                    modifier = Modifier.padding(10.dp),
                    tint = Color.Black
                )
            },
            // Cancel Button to delete all Input
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(
                        imageVector = image,
                        contentDescription = description,
                        tint = MaterialTheme.colors.primary
                    )
                }
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = modifier.height(20.dp))

        // Login Button and Login with Singpass
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = modifier.weight(1f))

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
                        .width(60.dp),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = modifier.weight(1f))

            Button(onClick = { /*TODO IF HAVE TIME*/ }) {
                // Register Function
                Text(
                    text = "Register",
                    style = MaterialTheme.typography.body2,
                    modifier = modifier
                        .padding(10.dp)
                        .width(60.dp),
                    textAlign = TextAlign.Center
                )

            }

            Spacer(modifier = modifier.weight(1f))
        }

    }

}

