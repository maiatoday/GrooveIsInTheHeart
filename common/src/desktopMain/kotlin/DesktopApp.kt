import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import net.maiatoday.giith.stars.StarsScreen

actual fun getPlatformName(): String = "Desktop"

actual fun isAndroid() = false

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