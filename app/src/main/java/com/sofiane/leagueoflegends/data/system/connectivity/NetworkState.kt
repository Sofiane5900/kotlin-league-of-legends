package com.sofiane.leagueoflegends.data.system.connectivity

/**
 * Représente l’état réseau actuel du device.
 *
 * Cette classe est un modèle "système"  qui permet à l’UI ou aux features
 * d'observer la connectivité en temps réel.
 *
 * @property isConnected Indique si l’appareil est connecté à un réseau (true = connecté).
 * @property ssid Nom du réseau Wi-Fi (SSID), ou `null`.
 * @property signalDbm Intensité du signal Wi-Fi en dBm, ou `null`.
 */
data class NetworkState(
    val isConnected: Boolean,
    val ssid: String? = null,
    val signalDbm: Int? = null,
)
