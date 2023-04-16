package net.maiatoday.giith.ui.colorSwatches

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Swatch(color: Color = Color.LightGray, size: Dp = 48.dp, name: String = "LightGray") {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier.padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color)
                .size(size)
        )
        Text(text = name)
    }
}

