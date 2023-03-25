package net.maiatoday.giith.blink

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.*
import net.maiatoday.giith.ui.components.BackButton

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BlinkScreen(onBack: () -> Unit = { }) {
    Surface(modifier = Modifier.fillMaxSize()) {
        var text by rememberSaveable { mutableStateOf("<blink>") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackButton(onBack = onBack)
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
            ThemedBlinkText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = spacer)
            BlinkText(
                text = text,
                color = Lime,
                modifier = Modifier
                    .padding(8.dp),
                style = MaterialTheme.typography.h4,
                durationMillis = 2000
            )
            Spacer(modifier = spacer)
//            LocalContentBlinkTag {
//                Column {
//                    Row {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//                            contentDescription = null // decorative element
//                        )
//                        Text(text = "blinky")
//                    }
//                    Row {
//                        Text(text = "pinky")
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//                            contentDescription = null // decorative element
//                        )
//                    }
//                    Row {
//                        Text(text = "inky")
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//                            contentDescription = null // decorative element
//                        )
//                    }
//
//                    Row {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//                            contentDescription = null // decorative element
//                        )
//                        Text(text = "clyde")
//                    }
//                }
//            }
            Spacer(modifier = spacer)
//            BlinkTag {
//                Column {
//                    Row {
//                        Icon(
//                            tint = Lollipop,
//                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//                            contentDescription = null // decorative element
//                        )
//                        Text(
//                            text = "blinky",
//                            color = Lollipop,
//                            modifier = it
//                                .padding(8.dp)
//                        )
//                    }
//                    Row {
//                        Text(
//                            text = "pinky",
//                            color = MyPonyHair,
//                            modifier = it
//                                .padding(8.dp)
//                        )
//                        Icon(
//                            tint = MyPonyHair,
//                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//                            contentDescription = null // decorative element
//                        )
//                    }
//                    Row {
//                        Text(
//                            text = "inky",
//                            color = SummerSky,
//                            modifier = it
//                                .padding(8.dp)
//                        )
//                        Icon(
//                            tint = SummerSky,
//                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//                            contentDescription = null // decorative element
//                        )
//                    }
//
//                    Row {
//                        Icon(
//                            tint = TrollHair,
//                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//                            contentDescription = null // decorative element
//                        )
//                        Text(
//                            text = "clyde",
//                            color = TrollHair,
//                            modifier = it
//                                .padding(8.dp)
//                        )
//                    }
//                }
//            }
        }
    }
}