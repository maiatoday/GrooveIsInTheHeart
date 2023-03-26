package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        }
    }
}