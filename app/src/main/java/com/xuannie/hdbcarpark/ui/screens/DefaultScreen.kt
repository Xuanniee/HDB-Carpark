package com.xuannie.hdbcarpark.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.xuannie.hdbcarpark.R
import com.xuannie.hdbcarpark.ui.HdbCarparkScreen
import androidx.compose.foundation.Image
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale

@Composable
fun DefaultScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {

        // User Profile Picture
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = stringResource(R.string.user_profile_pic_desc),
            modifier = modifier
                .height(200.dp)
                .widthIn(200.dp)
                .padding(20.dp)
        )

        // User Name
        Text(
            text = stringResource(id = R.string.john),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold
        )

        // User Points TODO Replace with SQL Implementations
        Row(
            modifier = modifier.padding(start = 10.dp, end = 10.dp)
        ){
            Text(
                text = "Points: 300",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold

            )
            
        }

        Spacer(modifier = modifier.height(20.dp))
        
        // Book Spots for Carpark
        Button(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Bookmark, contentDescription = "Chope your Parking Spot")
            Text(
                text = "Chope your Parking Spot here!!!",
                modifier = modifier
                    .width(250.dp)
                    .padding(start = 10.dp, end = 10.dp),
                maxLines = 1
            )
        }
        
        // Check Carpark
        Button(onClick = {
            navController.navigate(HdbCarparkScreen.carparkLocator.name)
        }) {
            Icon(imageVector = Icons.Filled.CarRental, contentDescription = "Check Carpark")
            Text(
                text = "Check the Carpark Status",
                modifier = modifier
                    .width(250.dp)
                    .padding(start = 10.dp, end = 10.dp),
                maxLines = 1
            )
        }
        
        // Activity History
        Button(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.History, contentDescription = "History")
            Text(
                text = "Activity History",
                modifier = modifier
                    .width(250.dp)
                    .padding(start = 10.dp, end = 10.dp),
                maxLines = 1
            )
        }

        // Report a Fault
        Button(
            onClick = {
                navController.navigate(HdbCarparkScreen.FaultReporting.name)
            }
        ) {
            Icon(imageVector = Icons.Filled.Report, contentDescription = "Report")
            Text(
                text = "Report a Fault",
                modifier = modifier
                    .width(250.dp)
                    .padding(start = 10.dp, end = 10.dp),
                maxLines = 1
            )
        }
        
    }

}

