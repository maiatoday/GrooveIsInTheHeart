package net.maiatoday.giith.demos.b_stars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.demos.g_heartpath.candyShader
import net.maiatoday.giith.ui.TheAiHelpedMe
import net.maiatoday.giith.demos.c_wallpaper.tools.PoissonDiscField
import net.maiatoday.giith.demos.c_wallpaper.tools.RandomField








//region Star Struck and how the AI helped me 🤩
@Composable
fun StarsScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val candyBrush = remember { candyShader }
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            // Visible two fields of stars
            RandomField(modifier = Modifier.weight(1.0f).fillMaxWidth())
            PoissonDiscField(modifier = Modifier.weight(1.0f).fillMaxWidth())
        }
        Box(
            modifier = Modifier.wrapContentSize().background(brush = candyBrush, alpha = 0.5f, shape = CircleShape).padding(8.dp)
        ) { TheAiHelpedMe() }
    }
}
//endregion




