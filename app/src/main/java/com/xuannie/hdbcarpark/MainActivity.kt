package com.xuannie.hdbcarpark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.xuannie.hdbcarpark.ui.HdbCarparkApp
import com.xuannie.hdbcarpark.ui.screens.AppViewModel
import com.xuannie.hdbcarpark.ui.theme.HDBCarparkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HDBCarparkTheme {
                val viewModel: AppViewModel =
                    viewModel(factory = AppViewModel.Factory)
                HdbCarparkApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HDBCarparkTheme {
        Greeting("Android")
    }
}