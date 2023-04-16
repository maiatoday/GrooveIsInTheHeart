package net.maiatoday.giith.demos.h_underconstruction

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.components.ConstructionWorker
import net.maiatoday.giith.ui.components.Flame

@Composable
fun UnderConstructionScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UnderConstructionMarqueeManual()
            ChevronHeavy(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Flame()
                ConstructionWorker(show = true)
                Flame()
            }
            Text(text = "🚧🔥🚧")
            Spacer(modifier = Modifier.height(16.dp))
            UnderConstructionMarquee()
            Chevron(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
        }
    }
}