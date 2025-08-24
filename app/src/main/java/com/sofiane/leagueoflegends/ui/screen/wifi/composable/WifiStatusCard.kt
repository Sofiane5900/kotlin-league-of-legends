package com.sofiane.leagueoflegends.ui.screen.wifi.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Wifi
import androidx.compose.material.icons.rounded.WifiOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sofiane.leagueoflegends.ui.theme.darkBackgroundBrush
import com.sofiane.leagueoflegends.ui.theme.goldBrush

@Composable
fun WifiStatusCard(
    isConnected: Boolean,
    ssid: String?,
    signalDbm: Int?
) {
    // TODO : déplacé toute la logique d'état dans une autre classe
    val statusText  = if (isConnected) "Connecté" else "Hors ligne"
    val statusColor = if (isConnected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
    // couleur du signal via un switch
    val signalColor = when {
        signalDbm == null -> MaterialTheme.colorScheme.onSurfaceVariant
        signalDbm >= -55  -> Color(0xFF2ECC71) // vert
        signalDbm >= -70  -> Color(0xFFF1C40F) // jaune
        else              -> Color(0xFFE74C3C) // rouge
    }
    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, goldBrush),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(darkBackgroundBrush, RoundedCornerShape(8.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (isConnected) Icons.Rounded.Wifi else Icons.Rounded.WifiOff,
                    contentDescription = null,
                    tint = statusColor
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = statusText,
                    style = MaterialTheme.typography.titleMedium,
                    color = statusColor
                )
            }

            Spacer(Modifier.height(12.dp))

            // ssid
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Réseau", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(ssid ?: "—", style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(Modifier.height(8.dp))

            // signal
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Signal", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(signalDbm?.let { "$it dBm" } ?: "—", style = MaterialTheme.typography.bodyMedium, color = signalColor)
            }
        }
    }
}