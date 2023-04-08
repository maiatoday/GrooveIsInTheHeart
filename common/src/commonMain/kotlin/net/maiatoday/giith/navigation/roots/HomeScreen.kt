package net.maiatoday.giith.navigation.roots

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.gaudydivider.SparkDivider
import net.maiatoday.giith.memphis.Memphis
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.Screen.Home
import net.maiatoday.giith.rainbowtext.SnappyRainbowText
import net.maiatoday.giith.wallpaper.Starfield

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    groovy: Boolean = false,
    switchChildScreen: (screen: Screen) -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        if (groovy) Memphis()
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            for (s in Screen.values()) {
                if (s != Home) {
                    Button(onClick = { switchChildScreen(s) }) {
                        Text(s.toString())
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            if (groovy) {
                SparkDivider(height = 16.dp)
                SnappyRainbowText(text = "Stay Groovy")
            }
        }
    }
}