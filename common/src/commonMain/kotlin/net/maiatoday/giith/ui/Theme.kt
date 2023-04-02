package net.maiatoday.giith.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = Lollipop,
    primaryVariant = SummerSky,
    secondary = Oros,
    secondaryVariant = TrollHair,
    onPrimary = Color.White,
    onSecondary = Color.White,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val DarkColorPalette = darkColors(
    primary = SherbetBomb,
    primaryVariant = TrollHair,
    secondary = FishTank,
    secondaryVariant = FishTank,
    onPrimary = Color.White,
    onSecondary = Color.White,
    background = CoughSyrup,
    onBackground = Color.White,
    surface = BlueyBlack,
    onSurface = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

enum class ThemeChoice {
    Comic, Times
}

@Composable
fun GrooveTheme(themeChoice: ThemeChoice = ThemeChoice.Times, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = if (themeChoice == ThemeChoice.Comic) grooveComicTypography else grooveTimesTypography,
        content = content
    )
}