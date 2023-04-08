package net.maiatoday.giith.wallpaper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.BlueStars
import net.maiatoday.giith.ui.PinkClouds
import net.maiatoday.giith.ui.UltraViolet
import net.maiatoday.giith.ui.grooveColors

enum class WallpaperChoice {
    CrazyQuilt, PinkClouds, BlueStars, UltraViolet
}

val radioGroupOptions = WallpaperChoice.values()

@Composable
fun WallpaperScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            var tt by remember { mutableStateOf(WallpaperChoice.CrazyQuilt) }
            Row(Modifier.fillMaxWidth()) {
                radioGroupOptions.forEach { choice ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = (choice == tt),
                                onClick = { tt = choice }
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (choice == tt),
                            onClick = { tt = choice }
                        )
                        Text(
                            text = choice.toString(),
                            style = MaterialTheme.typography.bodySmall.merge(),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
            Wallpaper(tt)
        }
    }
}

@Composable
fun Wallpaper(choice: WallpaperChoice) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(50) { _ ->
            when (choice) {
                WallpaperChoice.CrazyQuilt -> Box(
                    modifier = Modifier.size(100.dp).background(grooveColors.random())
                )

                WallpaperChoice.PinkClouds -> PinkClouds()
                WallpaperChoice.BlueStars -> BlueStars()
                WallpaperChoice.UltraViolet -> UltraViolet()
                else -> {}
            }
        }
    }

}
