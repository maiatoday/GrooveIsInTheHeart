package net.maiatoday.giith.underconstruction

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.components.ConstructionWorker
import net.maiatoday.magicsprinkles.ui.component.UnderConstructionMarquee

@Composable
fun UnderConstructionScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UnderConstructionMarquee()
            Chevron(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
            UnderConstructionMarquee()
            Spacer(modifier = Modifier.height(16.dp))
            ConstructionWorker()
            Text(text = "🚧🔥🚧")
            Spacer(modifier = Modifier.height(16.dp))
            UnderConstructionMarquee()
            Chevron(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
            UnderConstructionMarquee()
        }
    }
}