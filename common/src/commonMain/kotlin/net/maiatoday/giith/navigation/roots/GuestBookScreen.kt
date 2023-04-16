package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import isAndroid
import net.maiatoday.giith.demos.g_heartpath.LintDivider
import net.maiatoday.giith.demos.g_heartpath.SherbetBombDivider
import net.maiatoday.giith.demos.a_memphis.Memphis
import net.maiatoday.giith.demos.a_memphis.MemphisChoices
import net.maiatoday.giith.ui.BlueyBlack
import net.maiatoday.giith.ui.SummerSky
import net.maiatoday.giith.ui.components.Cube
import openBrowser

@Composable
fun GuestBookScreen() {
    Surface {
        Memphis(choices = MemphisChoices())
        Box(
            modifier = Modifier.padding(48.dp)
                .background(brush = SolidColor(BlueyBlack), alpha = 0.7f)
                .fillMaxSize()
        ) {
            Column {
                var guestBook by remember { mutableStateOf(sampleGuestBook) }
                GuestBook(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
                    guestBook += it
                }
                GuestBookEntries(modifier = Modifier.fillMaxSize(), guestBook)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestBook(modifier: Modifier = Modifier, onSubmit: (GuestBookEntry) -> Unit) {
    var name by remember {
        mutableStateOf("maiatoday")
    }
    var url by remember {
        mutableStateOf("https://maiatoday.net/")
    }
    var comment by remember {
        mutableStateOf("Thank you AndroidMakers x Droidcon 2023")
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Cube(show = !isAndroid())
            Text("Add to the Guest book", style = MaterialTheme.typography.titleLarge)
            Cube(show = !isAndroid())
        }
        Row {
            Text("Name: ")
            TextField(value = name, onValueChange = { newText -> name = newText })
        }
        Row {
            Text("Url: ")
            TextField(value = url, onValueChange = { newText -> url = newText })
        }
        Row {
            Text("Comment: ")
            TextField(value = comment, onValueChange = { newText -> comment = newText })
        }
        Row {
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    onSubmit(GuestBookEntry(name, url, comment))
                    name = ""
                    url = ""
                    comment = ""
                }) {
                Text("Submit")
            }
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    name = ""
                    url = ""
                    comment = ""
                }) {
                Text("Reset")
            }
        }
        SherbetBombDivider()
    }
}

@Composable
fun GuestBookEntries(modifier: Modifier = Modifier, entries: List<GuestBookEntry> = sampleGuestBook) {
    LazyColumn(modifier = modifier) {
        item {
            Text("Guest Book Entries", modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.titleLarge)
        }
        for (entry in entries) {
            item {
                with(entry) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = name,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            modifier = Modifier.padding(8.dp).clickable { openBrowser(uri) },
                            text = uri,
                            style = MaterialTheme.typography.bodySmall,
                            color = SummerSky,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                    Text(
                        modifier = Modifier.padding(start = 48.dp, top = 8.dp, bottom = 8.dp),
                        text = comment,
                        style = MaterialTheme.typography.headlineLarge
                    )

                }
                LintDivider()
            }
        }
    }
}

data class GuestBookEntry(val name: String, val uri: String, val comment: String)

val sampleGuestBook = listOf(
    GuestBookEntry(
        "Composionista",
        "https://developer.android.com/jetpack/compose/state",
        "Change the state to animate!"
    ),
    GuestBookEntry(
        "animate*AsState",
        "https://developer.android.com/jetpack/compose/animation",
        "I see numbers and colours and I want to animate!"
    ),
    GuestBookEntry(
        "ComposeAllTheThings!",
        "https://www.jetbrains.com/lp/compose-multiplatform/",
        "I <3 Compose multiplatform!"
    ),
    GuestBookEntry("LivingDesign", "https://artincontext.org/memphis-design/", "I never knew Memphis was a thing"),
    GuestBookEntry("Cameron", "https://www.cameronsworld.net/", "90s Nostalgia heats my computer"),
)