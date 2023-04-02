package net.maiatoday.giith.tiles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.grooveColors

@Composable
fun TilesScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(50) { _ ->
                Box(modifier = Modifier.size(100.dp).background(grooveColors.random()))
            }
        }
    }
}
