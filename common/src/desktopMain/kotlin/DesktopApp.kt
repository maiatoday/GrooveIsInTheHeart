import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.Dp
import net.maiatoday.giith.stars.StarsScreen
import org.jetbrains.compose.animatedimage.Blank
import org.jetbrains.compose.animatedimage.animate
import org.jetbrains.compose.animatedimage.loadResourceAnimatedImage
import org.jetbrains.compose.resources.loadOrNull

actual fun getPlatformName(): String = "Desktop"

actual fun openBrowser(url: String) {
    // launch browser on the desktop
}

@Composable
actual fun GifWrap(gifResource: String, showError: Boolean, size: Dp) {
    Image(
        loadOrNull { loadResourceAnimatedImage(gifResource) }?.animate() ?: ImageBitmap.Blank,
        contentDescription = null,
        Modifier.size(size)
    )
}

@Preview
@Composable
fun AppPreview() {
    App()
}

@Preview
@Composable
fun StarsPreview() {
    StarsScreen()
}