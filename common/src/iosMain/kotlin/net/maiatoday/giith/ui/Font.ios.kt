package net.maiatoday.giith.ui

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

private val cache: MutableMap<String, Font> = mutableMapOf()

@OptIn(ExperimentalResourceApi::class)
internal fun loadFont(
    res: String,
    weight: FontWeight = FontWeight.Normal,
    style: FontStyle = FontStyle.Normal
): Font {
    return cache.getOrPut(res) {
        val byteArray = runBlocking {
            try {
                resource("$res.ttf").readBytes()
            } catch (e: Exception) {
                resource("$res.otf").readBytes()
            }
        }
        Font(res, byteArray, weight, style)
    }
}

actual val ComicNeue = FontFamily(
    loadFont(res = "font/comic_neue_regular"),
    loadFont(res = "font/comic_neue_bold", FontWeight.Bold),
    loadFont(res = "font/comic_neue_light", FontWeight.Light)
)

actual val SourceSerif = FontFamily(
    loadFont(res  = "font/source_serif_pro_regular"),
    loadFont(res  = "font/source_serif_pro_bold", FontWeight.Bold),
    loadFont(res  = "font/source_serif_pro_light", FontWeight.Light),
    loadFont(res  = "font/source_serif_pro_black.", FontWeight.Black),
    loadFont(res  = "font/source_serif_pro_extra_light", FontWeight.ExtraLight),
)