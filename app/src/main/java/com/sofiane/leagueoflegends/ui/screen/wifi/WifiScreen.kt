package com.sofiane.leagueoflegends.ui.screen.wifi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sofiane.leagueoflegends.ui.screen.wifi.composable.WifiStatusCard

@Composable
fun WifiScreen(
    isConnected: Boolean,
    ssid: String?,
    signalDbm: Int?,
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(Modifier.width(8.dp))
                Text(
                    "Wi-Fi",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(Modifier.height(16.dp))

            WifiStatusCard(
                isConnected = isConnected,
                ssid = ssid,
                signalDbm = signalDbm
            )
        }
    }
}