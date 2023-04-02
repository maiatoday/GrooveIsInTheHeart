package net.maiatoday.giith.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = SherbetBomb,
    secondary = FishTank,
    tertiary = TrollHair,
    onPrimary = Color.White,
    onSecondary = Color.White,
    background = CoughSyrup,
    onBackground = Color.White,
    surface = BlueyBlack,
    onSurface = Color.White
)

enum class ThemeChoice {
    Comic, Times
}

@Composable
fun GrooveTheme(themeChoice: ThemeChoice = ThemeChoice.Times, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorPalette,
        typography = if (themeChoice == ThemeChoice.Comic) grooveComicTypography else grooveTimesTypography,
        content = content
    )
}