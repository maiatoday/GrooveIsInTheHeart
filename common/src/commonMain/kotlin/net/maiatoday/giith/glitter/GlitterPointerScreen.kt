package net.maiatoday.giith.glitter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.maiatoday.giith.ui.components.BackButton

@Composable
fun GlitterPointerScreen(onBack: () -> Unit = { }) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            BackButton(onBack = onBack)
            GlitterBox()
        }
    }
}