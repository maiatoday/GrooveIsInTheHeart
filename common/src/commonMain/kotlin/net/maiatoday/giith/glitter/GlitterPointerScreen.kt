package net.maiatoday.giith.glitter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.maiatoday.giith.ui.components.BackButton

@Composable
fun GlitterPointerScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            GlitterBox()
        }
    }
}