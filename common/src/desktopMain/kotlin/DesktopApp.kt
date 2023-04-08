import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import net.maiatoday.giith.stars.StarsScreen

actual fun getPlatformName(): String = "Desktop"

actual fun isAndroid() = false

actual fun openBrowser(url:String) {
    // launch browser on the desktop
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