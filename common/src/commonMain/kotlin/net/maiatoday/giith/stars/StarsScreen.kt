package net.maiatoday.giith.stars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.maiatoday.giith.wallpaper.PoissonDiscField
import net.maiatoday.giith.wallpaper.RandomField

@Composable
fun StarsScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),

            ) {
            RandomField(modifier = Modifier.weight(1.0f).fillMaxWidth())
            PoissonDiscField(modifier = Modifier.weight(1.0f).fillMaxWidth())
        }
    }
}


