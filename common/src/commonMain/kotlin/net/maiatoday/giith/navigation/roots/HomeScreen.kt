package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onColorSwatches: () -> Unit = { },
    onDoodleSketch: () -> Unit = { }
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Button(onClick = onColorSwatches) {
                Text("ColorSwatches")
            }
            Button(onClick = onDoodleSketch) {
                Text("DoodleSketch")
            }
        }
    }
}