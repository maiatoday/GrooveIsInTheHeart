package net.maiatoday.giith.tiles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TilesScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 172.dp)
            ) {

            }
        }
    }
}