package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.components.BackButton
import net.maiatoday.giith.components.Swatch
import net.maiatoday.giith.ui.grooveColorNames

@Composable
fun ColorSwatchesScreen(onBack: () -> Unit = { }) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row {
            BackButton(onBack = onBack)
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 172.dp)
            ) {
                for ((c, n) in grooveColorNames) {
                    item {
                        Swatch(color = c, name = n)
                    }
                }
            }
        }
    }
}