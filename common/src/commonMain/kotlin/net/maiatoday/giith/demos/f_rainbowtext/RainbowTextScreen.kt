package net.maiatoday.giith.demos.f_rainbowtext

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.components.Hot
import supportsGifs

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RainbowTextScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {

        var text by rememberSaveable { mutableStateOf("This ain't no disco!") }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val spacer = Modifier.height(16.dp)
            Text(
                "🌈",
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Rainbow message") }
            )
            MultiColorText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = spacer)
            SnappyRainbowText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = spacer)
            TwoColorSmoothText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineSmall,
                startColor = Color.Magenta,
                endColor = Color.Cyan,
                )
            Spacer(modifier = spacer)
            Row {
                MultiColorSmoothText(
                    text = text,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    duration = 1200
                )
                Hot(show = supportsGifs())
            }
            Spacer(modifier = spacer)
            Row {
                SmoothRainbowText(
                    text = text,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    duration = 1200
                )
                Hot(show = supportsGifs())
            }
            Spacer(modifier = spacer)
            RainbowGradientText(text)
            Spacer(modifier = spacer)
            GradientText(text)
            Spacer(modifier = spacer)
            AnotherGradientText(text)
            Spacer(modifier = spacer)
            Row {
                GradientTextShimmer(
                    text = text,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.headlineMedium
                )
                Hot(show = supportsGifs())
            }

        }
    }
}