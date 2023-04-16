package net.maiatoday.giith.demos.c_wallpaper

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
import net.maiatoday.giith.ui.*

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
                    Column(
                        modifier = Modifier
                            .selectable(
                                selected = (choice == tt),
                                onClick = { tt = choice }
                            )
                            .padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = choice.toString(),
                            style = MaterialTheme.typography.bodySmall.merge(),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        RadioButton(
                            selected = (choice == tt),
                            onClick = { tt = choice }
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
    when (choice) {
        WallpaperChoice.CrazyQuilt -> CrazyQuilt()
        WallpaperChoice.PinkClouds -> PinkCloudsBox {}
        WallpaperChoice.BlueStars -> BlueStarsBox {}
        WallpaperChoice.UltraViolet -> UltraVioletBox {}
    }

}

@Composable
fun CrazyQuilt() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(50) { _ ->
            Box(modifier = Modifier.size(100.dp).background(grooveColors.random()))
        }
    }
}


