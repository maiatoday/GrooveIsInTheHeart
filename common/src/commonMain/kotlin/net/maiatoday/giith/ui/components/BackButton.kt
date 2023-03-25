package net.maiatoday.giith.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BackButton(modifier:Modifier = Modifier, onBack:()-> Unit) {
    Button(modifier = modifier, onClick = onBack) { Text("Back") }
}