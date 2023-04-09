package net.maiatoday.giith.navigation.roots

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.gaudydivider.MoarSparkDivider
import net.maiatoday.giith.gaudydivider.RainbowSparkDivider
import net.maiatoday.giith.gaudydivider.ShimmerDivider
import net.maiatoday.giith.gaudydivider.SparkDivider
import net.maiatoday.giith.heartpath.CandyHeartPulse
import net.maiatoday.giith.memphis.Memphis
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.Screen.Home
import net.maiatoday.giith.rainbowtext.GradientTextShimmer
import net.maiatoday.giith.rainbowtext.SnappyRainbowText
import net.maiatoday.giith.ui.BlueyBlack
import net.maiatoday.giith.ui.UltraVioletBox
import net.maiatoday.giith.ui.components.Baby
import net.maiatoday.giith.ui.components.ConstructionWorker
import net.maiatoday.giith.ui.components.Pony
import net.maiatoday.giith.ui.vividRainbow
import net.maiatoday.giith.underconstruction.Chevron
import net.maiatoday.giith.visitorcounter.Counter

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
    var count by remember { mutableStateOf(12910) }
    Surface(modifier = modifier.fillMaxSize()) {
        //Memphis()
        UltraVioletBox()
        Box(
            modifier = Modifier
                .padding(64.dp)
                .alpha(0.7f)
                .background(color = BlueyBlack)
        )
        Box(
            modifier = Modifier
                .padding(64.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Pony()
                    Baby()
                    GradientTextShimmer(
                        text = "Welcome to my corner on the internet",
                        style = MaterialTheme.typography.headlineMedium,
                        colors = vividRainbow
                    )
                    Baby()
                    Pony()
                }
                ShimmerDivider(height = 8.dp, colors = vividRainbow)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    for (s in Screen.values()) {
                        if (s != Home) {
                            item {
                                Text(
                                    modifier = Modifier
                                        .clickable { switchChildScreen(s) },
                                    text = s.toString()
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Chevron(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
                SnappyRainbowText(text = "Stay Groovy")
                ConstructionWorker()
                Counter(count = count, width = 8, onClick = { count++ })
                CandyHeartPulse()
            }
        }
    }
}