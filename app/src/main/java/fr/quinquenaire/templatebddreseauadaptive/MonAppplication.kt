package fr.quinquenaire.projet12joiefull

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Point d'entrée Hilt.
 * Doit être déclaré dans AndroidManifest.xml :
 * <application android:name=".MonApplication" ... />
 */
@HiltAndroidApp
class MonApplication : Application()
