import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.ComposeUIViewController

actual fun getPlatformName(): String = "iOS"

actual fun openBrowser(url:String) {
    // launch browser on the desktop
}

@Composable
actual fun GifWrap(gifResource: String, show: Boolean, size: Dp) {}

fun MainViewController() = ComposeUIViewController { App() }