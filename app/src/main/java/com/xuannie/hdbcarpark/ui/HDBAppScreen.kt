package com.xuannie.hdbcarpark.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.Email
import androidx.compose.material.icons.twotone.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.xuannie.hdbcarpark.R
import com.xuannie.hdbcarpark.ui.screens.*
import com.xuannie.hdbcarpark.ui.theme.Grey900
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Enum Class for App Routes
enum class HdbCarparkScreen(@StringRes val title: Int) {
    Default(title = R.string.app_name),
    Login(title = R.string.Login),
    ParkingAvail(title = R.string.carpark_avail_title),
    FaultReporting(title = R.string.fault_reporting_flavour),
    Submission(title = R.string.success_screen_desc)
    carparkLocator(title = R.string.carpark_locator_desc),
}

/**
 * Composable that displays the topBar and displays a navigation menu
 */
@Composable
fun HdbAppTopBar(
    modifier: Modifier = Modifier,
    currentScreen: HdbCarparkScreen,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    // TODO Add a Logo Next Time
    TopAppBar(
        title = { Text(stringResource(id = currentScreen.title)) },
        modifier = modifier,
        navigationIcon =  {
            if (currentScreen != HdbCarparkScreen.Login) {
                IconButton(onClick = {
                    scope.launch { scaffoldState.drawerState.open() }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = stringResource(R.string.navbar_desc)
                    )
                }
            }
            else IconButton(onClick = {
                // TODO Does nothing
            }) {
                Icon(
                    imageVector = Icons.Filled.CarRepair,
                    contentDescription = null
                )
            }
        },
        elevation = 20.dp
    )
}

@Composable
fun HdbNavigationDrawer(
    modifier: Modifier = Modifier,
    scope: CoroutineScope,
    navController: NavHostController,
    scaffoldState: ScaffoldState,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()

    ) {
        // Headline Description
        // TODO Change with App Logo
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.TwoTone.Home,
                contentDescription = null,
                modifier = modifier
                    .weight(1f)
            )

            Spacer(modifier = modifier.weight(5f))

            // Icon to close the Navigation Drawer
            IconButton(
                onClick = {
                    scope.launch { scaffoldState.drawerState.close() }
                },
                modifier = modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = stringResource(R.string.menu_desc)
                )

            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h6,
            modifier = modifier.padding(
                start = 5.dp,
                end = 5.dp,
                top = 5.dp,
                bottom = 1.dp
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        Divider(
            thickness = 2.dp,
            color = Grey900,
            modifier = modifier.padding(2.dp)
        )

        /**
         *  Navigation Options / Buttons
         */

        /**
         *  Navigation Options / Buttons
         */
        // Home
        Button(
            onClick = {
                // Navigate to the Desired Route
                navController.navigate(HdbCarparkScreen.Default.name)
                // Close the App Drawer
                scope.launch { scaffoldState.drawerState.close() }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
        ) {
            Image(
                imageVector = Icons.Filled.Home,
                contentDescription = null,
                )
            Text(stringResource(R.string.home_nav_desc))
        }
        // Parking Avail
        Button(
            onClick = {
                // Navigate to the Desired Route
                navController.navigate(HdbCarparkScreen.ParkingAvail.name)
                // Close the App Drawer
                scope.launch { scaffoldState.drawerState.close() }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
        ) {
            Image(
                imageVector = Icons.Filled.Home,
                contentDescription = null,
            )
            Text("Parking Availability")
        }
        Button(
            onClick = {
                // Navigate to the Desired Route
                navController.navigate(HdbCarparkScreen.carparkLocator.name)
                // Close the App Drawer
                scope.launch { scaffoldState.drawerState.close() }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
        ) {
            Image(
                imageVector = Icons.Filled.Home,
                contentDescription = null,
            )
            Text("Parking Availability")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                // Navigate to the Desired Route
                navController.navigate(HdbCarparkScreen.Login.name)
                // Close the App Drawer
                scope.launch { scaffoldState.drawerState.close() }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 5.dp)
        ) {
            Text(text = "Log Out")
        }



//
//        // Search
//        Button(
//            onClick = {
//                navController.navigate(BusExpressScreen.Search.name)
//                scope.launch { scaffoldState.drawerState.close() }
//            },
//            modifier = modifier
//                .fillMaxWidth()
//                .padding(all = 5.dp)
//        ) {
//            Image(
//                imageVector = Icons.Filled.Search,
//                contentDescription = stringResource(R.string.search_nav_desc)
//            )
//            Text(stringResource(id = R.string.search_nav_desc))
//        }
//
//        // Favourites
//        Button(
//            onClick = {
//                favouriteBusStopViewModel.determineOutAndBack(
//                    goingOutFavouriteUiState = goingOutFavouriteUiState,
//                )
//                navController.navigate(BusExpressScreen.Favourites.name)
//                scope.launch { scaffoldState.drawerState.close() }
//            },
//            modifier = modifier
//                .fillMaxWidth()
//                .padding(all = 5.dp)
//        ) {
//            Image(
//                imageVector = Icons.Filled.Favorite,
//                contentDescription = null
//            )
//            Text(stringResource(R.string.favourites_navigation_desc))
//        }

        /**
         * Nearby is hidden as not built yet so can release the app
         */

        /**
         * Nearby is hidden as not built yet so can release the app
         */

    }

}

@Composable
fun HdbCarparkApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: AppViewModel
) {
    // Save Current Back Stack Entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Name of Current Screen as a Variable
    val currentScreen = HdbCarparkScreen.valueOf(
        backStackEntry?.destination?.route ?: HdbCarparkScreen.Default.name
    )
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    // Top Navigation Bar
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        drawerContent = {
            if (currentScreen != HdbCarparkScreen.Login) {
                viewModel.determineUserQuery("Test")
                HdbNavigationDrawer(
                    scope = scope,
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
        },
        drawerElevation = 20.dp,
//        drawerShape = NavigationDrawer,
        drawerGesturesEnabled = true,
        topBar = {
            // Top App Bar TODO
            HdbAppTopBar(
                currentScreen = currentScreen,
                scope = scope,
                scaffoldState = scaffoldState
            )

        }
    ) { innerPadding ->

        // NavHost Composable for Navigating between Screens
        NavHost(
            navController = navController,
            startDestination = HdbCarparkScreen.Login.name,
            modifier = modifier.padding(innerPadding)
        ) {
            // Routes for Every Screen in the App

            // 1. Login Page
            composable(route = HdbCarparkScreen.Login.name) {
                LoginScreen(navController = navController, modifier = modifier)
            }
            // 2. Default Screen
            composable(route = HdbCarparkScreen.Default.name) {
                DefaultScreen(navController = navController)
            }
            //ParkingSlot Screen
            composable(route = HdbCarparkScreen.ParkingAvail.name){
                ParkingSlotScreen(
                    currentScreen = currentScreen,
                    scope = scope,
                    scaffoldState = scaffoldState
                )
            }
            composable(route = HdbCarparkScreen.carparkLocator.name) {
                MapboxScreen()
            }

            composable(route = HdbCarparkScreen.FaultReporting.name) {
                FaultReportingChecklist(navController = navController)
            }

            composable(route = HdbCarparkScreen.Submission.name) {
                SubmissionScreen(navController = navController)
            }


        }


    }
}