import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Android"

actual fun isAndroid() = true

actual fun openBrowser(url:String) {
    // launch the browser
}