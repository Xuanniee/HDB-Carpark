package com.xuannie.hdbcarpark.ui.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.xuannie.hdbcarpark.R
import com.xuannie.hdbcarpark.ui.HdbCarparkScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

@Composable
fun RowWithThreeRectangles() {
    Row(modifier = Modifier.fillMaxWidth()
    ) {
        Rectangle(color = Color.Red)
        Rectangle(modifier = Modifier
            .weight(0.3f)
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
fun FullCarSlot() {
    val color = Color.Red

    Button(modifier = Modifier.clip(RoundedCornerShape(15.dp)), onClick = {},    colors = ButtonDefaults.buttonColors(backgroundColor = color )) {
        Image(
            painter = painterResource(id = R.drawable.stockcar),
            contentDescription = "Your Vehicle",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(60.dp)
        )
    }
}
@Composable
fun CarparkSeparator(){
    Rectangle(modifier = Modifier
        .height(13.dp)
        .width(120.dp),
        color = Color.Gray)
}
@Composable
fun EmptyCarSlot(
    viewModel: AppViewModel
){
    var selected by remember { mutableStateOf(false) }
    val color = if (selected) Color.Red else Color.Green


    Button(modifier = Modifier.clip(RoundedCornerShape( 15.dp)),onClick = {
        selected = !selected
        Log.d("DebugTag2", "${viewModel._pointsUiState.value}")
        viewModel._pointsUiState.value -= 15
        Log.d("DebugTag2", "${viewModel._pointsUiState.value}")
                                                                          },    colors = ButtonDefaults.buttonColors(backgroundColor = color )) {
        Image(
            painter = painterResource(id = R.drawable.emptycarparkstock),
            contentDescription = "Empty Slot",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(60.dp)
        )

    }
}
@Composable
fun Road(){

    Surface(modifier = Modifier.size(60.dp)) {

        Text("l", color = Color.LightGray, textAlign = TextAlign.Center)
    }
}

@Composable
fun ParkingSlotScreen(
    modifier: Modifier = Modifier,
    viewModel: AppViewModel,
    points: Int,
    currentScreen: HdbCarparkScreen,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
    ) {
    // Tab to select parking floor
//    val points by remember { mutableStateOf(100) }
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
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 50.dp, start = 20.dp)

                    ) {
                        FullCarSlot()
                        CarparkSeparator()
                        EmptyCarSlot(viewModel = viewModel)
                        CarparkSeparator()
                        EmptyCarSlot(viewModel = viewModel)


                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    Column(modifier = Modifier.padding(top = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Road()
                        Road()
                        Road()
                        Road()
                        Road()
                    }
                    Column(modifier = Modifier.padding(top = 50.dp, end = 20.dp), horizontalAlignment = Alignment.End) {
                        EmptyCarSlot(viewModel = viewModel)
                        CarparkSeparator()
                        EmptyCarSlot(viewModel = viewModel)
                        CarparkSeparator()
                        FullCarSlot()
                        Box( modifier = Modifier.padding(50.dp)){
                            Text( "Points : " + points.toString())
                        }
                    }
                }
            }

        }
        1 -> {

        }
        2 -> {

        }
    }

    // Hello
}

