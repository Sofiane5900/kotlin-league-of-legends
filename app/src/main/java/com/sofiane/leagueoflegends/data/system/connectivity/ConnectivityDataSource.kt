package com.sofiane.leagueoflegends.data.system.connectivity

import kotlinx.coroutines.flow.Flow

/**
 * Source de données qui expose l’état de la connectivité réseau.
 *
 * Abstraction qui permet d’observer la connexion en temps réel
 * (par exemple Wi-Fi ON/OFF, changement de SSID, intensité du signal).
 */
interface ConnectivityDataSource {
    /**
     * Observe en continu l’état réseau sous forme de [Flow].
     * - Émet un [NetworkState] initial.
     * - Réémet à chaque changement détecté.
     *
     * @return Un [Flow] de [NetworkState].
     */
    fun observeNetworkState(): Flow<NetworkState>
}