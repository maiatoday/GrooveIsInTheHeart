package net.maiatoday.giith.visitorcounter

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.ui.components.BackButton

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun VisitorCounterScreen(onBack: () -> Unit = { }) {
    var count by remember { mutableStateOf<Int>(0) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackButton(onBack = onBack)
            Counter(
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.h3,
                count = count,
                width = 8,
                onClick = { count += 10 }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Counter(
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.h4,
                count = count,
                width = 8,
                onClick = { count -= 5 }
            )
        }
    }
}