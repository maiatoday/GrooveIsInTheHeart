package net.maiatoday.giith.heartpath

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HeartPathScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        CandyHeartPulse()
    }
}