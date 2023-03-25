package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.maiatoday.giith.navigation.ChildScreen
import net.maiatoday.giith.navigation.Screen
val children = listOf(
    ChildScreen("ColorSwatches", Screen.ColorSwatches),
    ChildScreen("DoodleSketch", Screen.DoodleSketch),
    ChildScreen("RainbowText", Screen.RainbowText),
    ChildScreen("Blink", Screen.Blink),
    ChildScreen("GlitterPointer", Screen.GlitterPointer),
    ChildScreen("HeartPath", Screen.HeartPath),
    ChildScreen("UnderConstruction", Screen.UnderConstruction),
    ChildScreen("VisitorCounter", Screen.VisitorCounter),
    ChildScreen("GuestBook", Screen.GuestBook),
    ChildScreen("Links", Screen.Links),
)
@Composable
fun HomeScreen(
    switchChildScreen: (screen: Screen) -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            for ((name, screen) in children) {
                Button(onClick = { switchChildScreen(screen) }) {
                    Text(name)
                }
            }
        }
    }
}