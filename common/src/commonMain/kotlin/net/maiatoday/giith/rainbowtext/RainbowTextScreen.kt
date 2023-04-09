package net.maiatoday.giith.rainbowtext

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
            MultiColorSmoothText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineSmall,
                duration = 1200
            )
            Spacer(modifier = spacer)
//            SmoothRainbowText(
//                text = text,
//                modifier = Modifier.padding(8.dp),
//                style = MaterialTheme.typography.headlineMedium,
//                duration = 400
//            )
//            Spacer(modifier = spacer)
//            SmoothRainbowText(
//                text = text,
//                modifier = Modifier.padding(8.dp),
//                style = MaterialTheme.typography.headlineMedium,
//                duration = 1200
//            )
//            Spacer(modifier = spacer)
//            SmoothRainbowText(
//                text = text,
//                modifier = Modifier.padding(8.dp),
//                style = MaterialTheme.typography.headlineMedium,
//                duration = 6400
//            )
//            Spacer(modifier = spacer)
            RainbowGradientText(text)
            Spacer(modifier = spacer)
            GradientText(text)
            Spacer(modifier = spacer)
            AnotherGradientText(text)
            Spacer(modifier = spacer)
            GradientTextShimmer(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineMedium)

        }
    }
}