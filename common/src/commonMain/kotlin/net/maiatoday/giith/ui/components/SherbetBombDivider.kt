package net.maiatoday.giith.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.SherbetBomb

@Composable
fun SherbetBombDivider(modifier: Modifier = Modifier) {
    Spacer(modifier.background(SherbetBomb).height(2.dp).fillMaxWidth())
}