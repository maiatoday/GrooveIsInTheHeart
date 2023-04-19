@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class, ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class
)

package net.maiatoday.giith.demos.d_blink

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.*







//region Blink Twice
@Composable
fun BlinkScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        var text by rememberSaveable { mutableStateOf("<blink>") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //region Blink text
            //region Setup to enter the text
            val spacer = Modifier.height(16.dp)
            Text(
                "<blink>",
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Blink message") }
            )
            Spacer(modifier = spacer)
            //endregion
            BlinkText(
                text = text,
                color = Lime,
                modifier = Modifier
                    .padding(8.dp),
                style = MaterialTheme.typography.headlineMedium,
                durationMillis = 2000
            )
            Spacer(modifier = spacer)
            //endregion

            //region Ghosts
            // >>>>>>>>>> State show don't show
            var show by remember { mutableStateOf(false) }
            VulnerableGhost(
                modifier = Modifier.clickable { show = !show }
            )
            Spacer(modifier = spacer)

            // >>>>>>>>>> Visible Change
            AnimatedVisibility(visible = show) {
                TheGhosts()
            }
            //endregion
        }
    }
}
//endregion

//region All the Ghosts details
@Composable
fun TheGhosts(
    modifier: Modifier = Modifier.width(300.dp)
) {
    Column(modifier) {
        Row(modifier = Modifier.basicMarquee()) {
            Blinky()
            Pinky()
            Inky()
            Clyde()
        }
    }
}

@Composable
private fun Clyde() {
    Row {
        Clyde(60.dp)
        Text(
            text = "Clyde",
            color = TrollHair,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
private fun Inky() {
    Row {
        Inky(60.dp)
        Text(
            text = "Inky",
            color = SummerSky,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
private fun Pinky() {
    Row {
        Pinky(60.dp)
        Text(
            text = "Pinky",
            color = MyPonyHair,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
private fun Blinky() {
    Row {
        Blinky(60.dp)
        Text(
            text = "Blinky",
            color = Lollipop,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}
//endregion de
