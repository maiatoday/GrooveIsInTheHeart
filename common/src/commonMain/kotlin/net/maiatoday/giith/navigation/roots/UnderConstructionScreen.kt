package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.maiatoday.giith.components.BackButton
import net.maiatoday.giith.navigation.Screen

@Composable
fun UnderConstructionScreen(onBack: () -> Unit = { }) {
    Surface(modifier = Modifier.fillMaxSize()) {
        BackButton(onBack = onBack)
    }
}