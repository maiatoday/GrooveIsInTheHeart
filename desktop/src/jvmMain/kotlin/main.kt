import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val icon = painterResource("groove.png")
    Window(
        title = "Groove is in the 💗",
        icon = icon,
        state = rememberWindowState(width = 1200.dp, height = 850.dp),
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}