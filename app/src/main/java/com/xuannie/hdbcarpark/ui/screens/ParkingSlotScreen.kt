package com.xuannie.hdbcarpark.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.*
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale

@Composable
fun RowWithThreeRectangles() {
    Row(modifier = Modifier.fillMaxWidth()
    ) {
        Rectangle(color = Color.Red)
        Rectangle(modifier = Modifier.weight(0.3f)
            .height(64.dp),
            color = Color.Blue)
        Rectangle(modifier = Modifier.weight(0.7f),
            color = Color.Green)
    }
}

@Composable
fun Rectangle(color: Color,
              modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.composed {
            size(32.dp)
                .clip(RectangleShape)
                .background(color)
        }
    )
}

@Composable
fun CarButton() {

}

@Composable
fun ParkingSlotScreen(
    modifier: Modifier = Modifier,
    currentScreen: HdbCarparkScreen,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
    ) {
    // Tab to select parking floor
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Floor 1", "Floor 2", "Floor 3")
    TabRow(selectedTabIndex = state) {
        titles.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = state == index,
                onClick = { state = index }
            )
        }
    }
    when (state) {
        0 -> {
            Box(modifier= Modifier.padding(vertical = 40.dp)) {

                //Image(painter = painterResource(id = R.drawable.singpass_logo), contentDescription = "Background")
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 50.dp, start = 20.dp)
                            .border(border = BorderStroke(width = 1.dp, Color.LightGray))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.stockcar),
                            contentDescription = "Your Vehicle",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                    Column(modifier = Modifier.padding(top = 50.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.stockcar),
                            contentDescription = "Your Vehicle",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                    Column(modifier = Modifier.padding(top = 50.dp, end = 20.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.stockcar),
                            contentDescription = "Your Vehicle",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                }
            }

        }
        1 -> {

        }
        2 -> {

        }
    }

    Column (
        //modifier = modifier
         //   .padding(20.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {

        //Spacer(modifier = modifier.height(70.dp))


        Rectangle(modifier = Modifier.height(13.dp)
            .width(120.dp),
            color = Color.Gray)
        Spacer(modifier = modifier.height(70.dp))
        Rectangle(modifier = Modifier.height(13.dp)
            .width(120.dp),
            color = Color.Gray)
        Spacer(modifier = modifier.height(70.dp))
        Rectangle(modifier = Modifier.height(13.dp)
            .width(120.dp),
            color = Color.Gray)
        Spacer(modifier = modifier.height(70.dp))
        Rectangle(modifier = Modifier.height(13.dp)
            .width(120.dp),
            color = Color.Gray)
        Spacer(modifier = modifier.height(70.dp))
        Rectangle(modifier = Modifier.height(13.dp)
            .width(120.dp),
            color = Color.Gray)
        Spacer(modifier = modifier.height(70.dp))
        Rectangle(modifier = Modifier.height(13.dp)
            .width(120.dp),
            color = Color.Gray)
        Spacer(modifier = modifier.height(70.dp))
        Rectangle(modifier = Modifier.height(13.dp)
            .width(120.dp),
            color = Color.Gray)

    }

    // Hello
}