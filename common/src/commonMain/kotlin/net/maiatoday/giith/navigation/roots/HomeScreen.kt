package net.maiatoday.giith.navigation.roots

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.gaudydivider.MoarSparkDivider
import net.maiatoday.giith.gaudydivider.RainbowSparkDivider
import net.maiatoday.giith.gaudydivider.ShimmerDivider
import net.maiatoday.giith.gaudydivider.SparkDivider
import net.maiatoday.giith.memphis.Memphis
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.Screen.Home
import net.maiatoday.giith.rainbowtext.GradientTextShimmer
import net.maiatoday.giith.rainbowtext.SnappyRainbowText
import net.maiatoday.giith.ui.BlueyBlack
import net.maiatoday.giith.ui.components.ConstructionWorker
import net.maiatoday.giith.ui.vividRainbow
import net.maiatoday.giith.underconstruction.Chevron

@Composable
fun HomeScreen(
    groovy: Boolean = false,
    switchChildScreen: (screen: Screen) -> Unit = {}
) {
    if (groovy) GroovyHome(switchChildScreen = switchChildScreen)
    else SimpleHome(switchChildScreen = switchChildScreen)
}

@Composable
fun SimpleHome(modifier: Modifier = Modifier, switchChildScreen: (screen: Screen) -> Unit = {}) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            for (s in Screen.values()) {
                if (s != Home) {
                    Button(onClick = { switchChildScreen(s) }) {
                        Text(s.toString())
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GroovyHome(modifier: Modifier = Modifier, switchChildScreen: (screen: Screen) -> Unit = {}) {
    Surface(modifier = modifier.fillMaxSize()) {
        Memphis()
        Box(
            modifier = Modifier
                .padding(64.dp)
                .background(color = BlueyBlack)
                //.alpha(0.7f)
        ) {
            Column {
                GradientTextShimmer(
                    text = "Welcome to my corner on the internet",
                    style = MaterialTheme.typography.displayMedium
                )

                SparkDivider(height = 16.dp)
                Spacer(modifier = Modifier.height(8.dp))
                MoarSparkDivider(height = 16.dp)
                Spacer(modifier = Modifier.height(8.dp))
                RainbowSparkDivider(height = 16.dp)
                Spacer(modifier = Modifier.height(8.dp))
                ShimmerDivider(height = 16.dp, colors = vividRainbow)
                Spacer(modifier = Modifier.height(8.dp))
                ConstructionWorker()
                Chevron(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
                SnappyRainbowText(text = "Stay Groovy")

            }
        }
    }
}