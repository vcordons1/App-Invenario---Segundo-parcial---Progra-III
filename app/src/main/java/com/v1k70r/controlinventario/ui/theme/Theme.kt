package com.v1k70r.controlinventario.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryRed,
    secondary = DarkSurface,
    tertiary = TextGray,
    background = DarkBG,
    surface = DarkSurface,
    onPrimary = Color.White,
    onSecondary = TextWhite,
    onTertiary = Color.Black,
    onBackground = TextWhite,
    onSurface = TextWhite
)

@Composable
fun ControlInventarioTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}