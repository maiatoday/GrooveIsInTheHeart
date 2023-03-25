package net.maiatoday.giith.ui

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import net.maiatoday.giith.common.R

actual val ComicNeue = FontFamily(
    Font(R.font.comic_neue_regular),
    Font(R.font.comic_neue_bold, FontWeight.Bold),
    Font(R.font.comic_neue_light, FontWeight.Light)
)

actual val SourceSerif = FontFamily(
    Font(R.font.source_serif_pro_regular),
    Font(R.font.source_serif_pro_bold, FontWeight.Bold),
    Font(R.font.source_serif_pro_light, FontWeight.Light),
    Font(R.font.source_serif_pro_black, FontWeight.Black),
    Font(R.font.source_serif_pro_extra_light, FontWeight.ExtraLight),
)