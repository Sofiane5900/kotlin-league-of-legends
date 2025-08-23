package com.sofiane.leagueoflegends

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Classe Application principale.
 *
 * Annotée avec [HiltAndroidApp], elle sert de point d'entrée
 * pour l'initialisation de la DI Dagger Hilt dans l'application.
 *
 * Cette classe est créée avant toute autre classe et reste
 * vivante tant que l'application est en mémoire.
 */
@HiltAndroidApp
class MvvmApp : Application() {
}