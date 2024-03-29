import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import net.maiatoday.giith.ui.imageResourcePainter

actual fun getPlatformName(): String = "Android"

actual fun openBrowser(url: String) {
//    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//    startActivity(LocalContext.current, browserIntent, null)
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