package net.maiatoday.giith.ui

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontFamily

expect val ComicNeue: FontFamily
expect val SourceSerif: FontFamily

// Set of Material typography styles to start with
val grooveComicTypography = Typography(
    defaultFontFamily = ComicNeue,
)

val grooveTimesTypography = Typography(
    defaultFontFamily = SourceSerif,
)