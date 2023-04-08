import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Desktop"

actual fun isAndroid() = false

@Preview
@Composable
fun AppPreview() {
    App()
}