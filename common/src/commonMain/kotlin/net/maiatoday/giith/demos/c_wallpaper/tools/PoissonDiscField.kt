package net.maiatoday.giith.demos.c_wallpaper.tools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import net.maiatoday.giith.tools.buildPoissonDiscPoints
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.BlueyBlack

@Composable
fun PoissonDiscField(modifier: Modifier = Modifier, background: Color = BlueyBlack, starColor: Color = Color.White) {
    BoxWithConstraints(modifier) {
        val w = this.maxWidth.toPx()
        val h =  this.maxHeight.toPx()
        val stars by remember { mutableStateOf(buildPoissonDiscPoints(Size(w, h))) }
        Box(
            modifier = modifier
                .background(background)
                .paint(StarPainter(starColor, stars))
        )
    }
}