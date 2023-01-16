package com.xuannie.hdbcarpark.ui.screens

import android.widget.GridLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mapbox.maps.MapView
import com.mapbox.maps.ResourceOptionsManager
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.xuannie.hdbcarpark.R
import android.os.Bundle
import androidx.core.app.ComponentActivity
import com.mapbox.common.location.compat.permissions.PermissionsManager


/**
 * Tracks the user location on screen, simulates a navigation session.
 */





@Composable
fun MapboxScreen() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    )
    {

        AndroidView(
            modifier = Modifier,
            factory = { context ->
                ResourceOptionsManager.getDefault(
                    context,
                    context.getString(R.string.mapbox_access_token)
                )

                MapView(context).apply {
                    getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) {
                        cameraOptions {
                            zoom(19.0)
                        }
                    }
                }
            }
        )
    }
}