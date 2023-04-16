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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import net.maiatoday.giith.tools.buildPoints
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.BlueyBlack
import net.maiatoday.giith.ui.TasteyWheat

@Composable
fun RandomField(modifier: Modifier = Modifier, background: Color = BlueyBlack, starColor: Color = TasteyWheat) {
    BoxWithConstraints(modifier) {
        val w = this.maxWidth.toPx().toInt()
        val h =  this.maxHeight.toPx().toInt()
        val stars by remember { mutableStateOf(buildPoints(IntSize(w,h), 3000)) }
        Box(
            modifier = modifier
                .background(background)
                .paint(StarPainter(starColor, stars))
        )
    }
}