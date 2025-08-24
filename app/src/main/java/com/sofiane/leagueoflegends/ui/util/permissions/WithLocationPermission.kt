package com.sofiane.leagueoflegends.ui.util.permissions

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat


/**
 * Fonction utilitaire qui demande la permission de localisation et affiche un contenu selon le résultat.
 *
 * @param onGranted à montrer quand la localisation est autorisée.
 * @param onDenied  si l’utilisateur refuse.
 *
 */
@Composable
fun WithLocationPermission(
    onGranted: @Composable () -> Unit,
    onDenied: @Composable () -> Unit = {}
) {
    val context = LocalContext.current
    var granted by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        granted = result.any { it.value } // permission fine ou coarse suffit pour le ssid
    }

    LaunchedEffect(Unit) {
        val perms = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        val missing = perms.any {
            ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
        }
        if (missing) {
            launcher.launch(perms)
        } else {
            granted = true
        }
    }
    if (granted) {
        onGranted()
    }
    else {
        onDenied()
    }
}