package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.maiatoday.giith.components.BackButton

@Composable
fun RainbowTextScreen(onBack: () -> Unit = { }) {
    Surface(modifier = Modifier.fillMaxSize()) {
        BackButton(onBack = onBack)
    }
}