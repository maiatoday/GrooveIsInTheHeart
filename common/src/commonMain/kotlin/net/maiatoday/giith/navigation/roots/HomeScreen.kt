package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.gaudydivider.SparkDivider
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.Screen.Home

@Composable
fun HomeScreen(
    switchChildScreen: (screen: Screen) -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            for (s in Screen.values()) {
                if (s != Home) {
                    Button(onClick = { switchChildScreen(s) }) {
                        Text(s.toString())
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            SparkDivider(height = 16.dp)
        }
    }
}