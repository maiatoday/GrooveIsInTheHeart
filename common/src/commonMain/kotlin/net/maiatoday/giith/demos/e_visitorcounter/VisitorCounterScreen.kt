package net.maiatoday.giith.demos.e_visitorcounter

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun VisitorCounterScreen() {
    var count by remember { mutableStateOf(0) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Button(onClick = { count += 10 }, modifier = Modifier.padding(8.dp)) { Text("Up") }
                Button(onClick = { count -= 5 }, modifier = Modifier.padding(8.dp)) { Text("Down") }

            }
            Counter(
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.headlineLarge,
                count = count,
                width = 8,
                onClick = { count += 10 }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Counter(
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.headlineMedium,
                count = count,
                width = 8,
                onClick = { count -= 5 }
            )
            Spacer(modifier = Modifier.height(64.dp))
            CounterCell(
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.headlineSmall,
                count = count,
                width = 8)

        }
    }
}