package fr.quinquenaire.projet12joiefull.presentation

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Thème Material 3 de l'application Joiefull.
 *
 * Utilise les couleurs dynamiques (Material You) si l'appareil
 * est sous Android 12+ (API 31). Sinon, utilise un thème par défaut.
 *
 * Les couleurs dynamiques s'adaptent au fond d'écran de l'utilisateur,
 * ce qui donne un look personnalisé à chaque appareil.
 *
 * @param darkTheme    : true si le mode sombre est activé
 * @param dynamicColor : true pour utiliser les couleurs dynamiques (Android 12+)
 * @param content      : les Composables enfants qui héritent du thème
 */
@Composable
fun JoiefullTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Sélection du schéma de couleurs selon le contexte :
    // 1. Si Android 12+ et dynamicColor activé → couleurs du fond d'écran
    // 2. Sinon → schéma par défaut (clair ou sombre)
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        darkTheme -> darkColorScheme()
        else -> lightColorScheme()
    }

    // MaterialTheme propage le colorScheme à tous les Composables enfants.
    // Chaque composant Material 3 (Button, Card, Text...) utilise
    // automatiquement les bonnes couleurs du thème.
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}