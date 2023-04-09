package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.gaudydivider.LintDivider
import net.maiatoday.giith.gaudydivider.SherbetBombDivider
import net.maiatoday.giith.ui.TasteyWheat
import net.maiatoday.giith.ui.UltraVioletBox
import net.maiatoday.giith.ui.components.Cube

@Composable
fun GuestBookScreen() {
    UltraVioletBox {
        Box(modifier = Modifier.padding(48.dp).background(TasteyWheat).fillMaxSize()) {
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
        mutableStateOf("")
    }
    var url by remember {
        mutableStateOf("")
    }
    var comment by remember {
        mutableStateOf("")
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Cube()
            Text("Add to the Guest book", style = MaterialTheme.typography.titleLarge)
            Cube()
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
            Button(onClick = {
                onSubmit(GuestBookEntry(name, url, comment))
                name = ""
                url = ""
                comment = ""
            }) {
                Text("Submit")
            }
            Button(onClick = {
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = entry.name,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = entry.uri,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 48.dp),
                    text = entry.comment,
                    style = MaterialTheme.typography.bodySmall
                )
                LintDivider()
            }
        }
    }
}

data class GuestBookEntry(val name: String, val uri: String, val comment: String)

val sampleGuestBook = listOf(
    GuestBookEntry("Flopsy", "http://dodgy.net", "curious"),
    GuestBookEntry("Mopsy", "http://yeoldwebsite.net", "I wonder where they hid the carrots"),
    GuestBookEntry("Cotton Tail", "http://carrotpatch.net", "I wandered around in your website and it  was nostalgic"),
    GuestBookEntry("Peter", "http://runrunrun.net", "Macgregors nemesis"),
)