package net.maiatoday.giith.underconstruction

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.components.BackButton
import net.maiatoday.magicsprinkles.ui.component.UnderConstructionMarquee

@Composable
fun UnderConstructionScreen(onBack: () -> Unit = { }) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackButton(onBack = onBack)
            UnderConstructionMarquee()
            Chevron(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
            UnderConstructionMarquee()
            Spacer(modifier = Modifier.height(16.dp))
            //Cone()
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