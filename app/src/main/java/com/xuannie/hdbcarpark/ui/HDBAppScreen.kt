package com.xuannie.hdbcarpark.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.xuannie.hdbcarpark.R

// Enum Class for App Routes
enum class HdbCarparkScreen(@StringRes val title: Int) {
    Default(title = R.string.app_name),

}

@Composable
fun HdbCarparkApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    // Save Current Back Stack Entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Name of Current Screen as a Variable
    val currentScreen = BusExpressScreen.valueOf(
        backStackEntry?.destination?.route ?: BusExpressScreen.Default.name
    )
    val scaffoldState = rememberScaffoldState()

    // Top Navigation Bar
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        drawerContent = {
            // TODO Add a Composable for Navigation

        },
        drawerElevation = 20.dp,
        drawerShape = NavigationDrawer,
        drawerGesturesEnabled = true,
        topBar = {
            // Top App Bar TODO
            )
        }
    ) { innerPadding ->
        // For Small Menu Popup
        val menuSelection = remember { mutableStateOf(MenuSelection.NONE) }

        // State Variables
        val busServiceBoolUiState = appViewModel.busServiceBoolUiState

        // NavHost Composable for Navigating between Screens
        NavHost(
            navController = navController,
            startDestination = BusExpressScreen.Default.name,
            modifier = modifier.padding(innerPadding)
        ) {
            // Routes for Every Screen in the App

            // 1. Default Screen (For Nearby Bus-stops)
            composable(route = BusExpressScreen.Default.name) {
                DefaultScreen(navController = navController)
            }

            // 2. Search Screen
            composable(route = BusExpressScreen.Search.name) {
                SearchScreen(
                    busUiState = appViewModel.busUiState,
                    busArrivalsJson = SingaporeBus(
                        metaData = busServiceUiState.metaData,
                        busStopCode = busServiceUiState.busStopCode,
                        services = busServiceUiState.services
                    ),
                    busStopDetails = BusStopValue(
                        busStopCode = busStopNameUiState.busStopCode,
                        busStopRoadName = busStopNameUiState.busStopRoadName,
                        busStopDescription = busStopNameUiState.busStopDescription,
                        latitude = busStopNameUiState.latitude,
                        longitude = busStopNameUiState.longitude
                    ),
                    busRoutes = BusRoutes(
                        metaData = busRouteUiState.metaData,
                        busRouteArray = busRouteUiState.busRouteArray
                    ),
                    busServiceBool = busServiceBoolUiState,
                    viewModel = appViewModel,
                    busServicesRouteList = multipleBusUiState,
                    currentScreen = currentScreen,
                    favouriteBusStopViewModel = favouriteBusStopViewModel,
                    menuSelection = menuSelection,
                )
            }

            // 3. Nearby Screen
            composable(route = BusExpressScreen.Nearby.name) {
                NearbyScreen(
                )
            }

            // 3. Favourites [Going Out]
            composable(route = BusExpressScreen.Favourites.name) {
                FavouritesScreen(
                    favouriteBusStopViewModel = favouriteBusStopViewModel,
                    busStopsInFavourites = busStopsInFavourites,
                    appViewModel = appViewModel
                )
            }


        }


    }
}