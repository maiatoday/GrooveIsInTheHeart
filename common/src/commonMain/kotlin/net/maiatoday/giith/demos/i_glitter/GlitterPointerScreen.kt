package net.maiatoday.giith.demos.i_glitter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GlitterPointerScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            GlitterBox()
        }
    }
}