package net.maiatoday.giith.ui

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font


actual val ComicNeue = FontFamily(
    Font(resource = "font/comic_neue_regular.ttf"),
    Font(resource = "font/comic_neue_bold.ttf", FontWeight.Bold),
    Font(resource = "font/comic_neue_light.ttf", FontWeight.Light)
)

actual val SourceSerif = FontFamily(
    Font(resource  = "font/source_serif_pro_regular.ttf"),
    Font(resource  = "font/source_serif_pro_bold.ttf", FontWeight.Bold),
    Font(resource  = "font/source_serif_pro_light.ttf", FontWeight.Light),
    Font(resource  = "font/source_serif_pro_black.ttf", FontWeight.Black),
    Font(resource  = "font/source_serif_pro_extra_light.ttf", FontWeight.ExtraLight),
)