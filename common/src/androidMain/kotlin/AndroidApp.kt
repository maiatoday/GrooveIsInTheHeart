import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import net.maiatoday.giith.ui.imageResourcePainter

actual fun getPlatformName(): String = "Android"

actual fun openBrowser(url: String) {
    // launch the browser
}

@Composable
actual fun GifWrap(gifResource: String, show: Boolean, size: Dp) {
    if (show) {
        val brokenFile = imageResourcePainter("bork.png")
        Image(
            modifier = Modifier.size(size),
            painter = brokenFile,
            contentDescription = "Broken file"
        )
    }
}