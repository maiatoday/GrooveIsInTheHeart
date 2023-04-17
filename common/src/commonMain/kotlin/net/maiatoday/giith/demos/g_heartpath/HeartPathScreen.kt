package net.maiatoday.giith.demos.g_heartpath

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.maiatoday.giith.ui.pastelRainbow

@Composable
fun HeartPathScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        MoarSparkDivider(spark = pastelRainbow)
        Column {
            SherbetBombDivider()
            ShimmerDivider()
            CandyHeartPulse()
        }
    }
}