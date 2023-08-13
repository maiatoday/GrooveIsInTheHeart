package net.maiatoday.giith.ui

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Typeface
import org.jetbrains.skia.FontStyle
import org.jetbrains.skia.Typeface

private fun loadCustomFont(name: String): Typeface {
    return Typeface.makeFromName(name, FontStyle.NORMAL)
}


actual val ComicNeue = FontFamily(
    Typeface(loadCustomFont("comic_neue"))
)

actual val SourceSerif = FontFamily(
    Typeface(loadCustomFont("source_serif_pr")),
)