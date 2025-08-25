package com.sofiane.leagueoflegends.data.remote.ddragon

/**
 * Contient les URLs de base pour les images fournies par Riot Data Dragon.
 *
 * À utiliser avec le nom du champion pour construire une URL complète.
 */
// TODO(Benji): C'est clairement lié à une implémentationd de DS (DataSource), ça ne doit pas être un fichier à part. Si demain je de dit d'utiliser une autre API tout ce qui est ici n'est plus valable.
object RiotImageConstant {
    const val SPLASH = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/"
    const val SQUARE = "https://ddragon.leagueoflegends.com/cdn/15.16.1/img/champion/"
    const val PASSIVE = "https://ddragon.leagueoflegends.com/cdn/15.16.1/img/passive/"
    const val SPELL = "https://ddragon.leagueoflegends.com/cdn/15.16.1/img/spell/"
}