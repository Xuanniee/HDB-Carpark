package com.xuannie.hdbcarpark.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.xuannie.hdbcarpark.R
import com.xuannie.hdbcarpark.ui.HdbCarparkScreen

@Composable
fun SubmissionScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.checkmark),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(50.dp)

        )

        Text(
            text = "Thank you for your report!!",
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Your submission has been received!!",
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Bold
        )

        Button(onClick = {
            navController.navigate(HdbCarparkScreen.Default.name)
        }) {
            Text(
                text = "Go Back",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold
            )

        }

    }
}