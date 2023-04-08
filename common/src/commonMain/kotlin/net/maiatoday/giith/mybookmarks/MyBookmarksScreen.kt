package net.maiatoday.giith.mybookmarks

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.*
import net.maiatoday.giith.ui.components.Baby
import net.maiatoday.giith.wallpaper.PoissonDiscField
import net.maiatoday.giith.wallpaper.RandomField
import openBrowser

@Composable
fun MyBookmarksScreen() {
    BlueStarsBox {
        Box(modifier = Modifier.padding(48.dp).background(Lint).fillMaxSize()) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Baby()
                    Text("My Bookmarks", style = MaterialTheme.typography.titleLarge)
                    Baby()
                }
                Row {
                    BookmarkList(title = "Inspiration", Inspiration)
                    BookmarkList(title = "Tools", Tools)
                }
            }
        }
    }
}

@Composable
fun BookmarkList(title:String, links:List<Bookmark>) {
    LazyColumn {
        item {
            Text(title)
        }
        for (l in links) {
            item {
                LinkItem(l)
            }
        }
    }
}

@Composable
fun LinkItem(link:Bookmark) {
    Text(text = link.text, modifier = Modifier
        .clickable { openBrowser(link.url) }
    )
}

data class Bookmark(val text:String, val url:String)

val Inspiration = listOf(
    Bookmark("asdf", "Asdf")
)

val Tools = listOf(
    Bookmark("asdf", "Asdf")
)


