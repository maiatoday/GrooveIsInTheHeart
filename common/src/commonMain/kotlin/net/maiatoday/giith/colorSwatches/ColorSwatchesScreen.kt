package net.maiatoday.giith.colorSwatches

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.components.BackButton
import net.maiatoday.giith.ui.components.Pony
import net.maiatoday.giith.ui.components.Troll
import net.maiatoday.giith.ui.grooveColorNames

@Composable
fun ColorSwatchesScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 172.dp)
            ) {
                for ((c, n) in grooveColorNames) {
                    item {
                        Swatch(color = c, name = n)
                    }
                    if (n.contains("Troll")) item { Troll() }
                    if (n.contains("Pony")) item { Pony() }
                }
            }
        }
    }
}