package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.demos.c_wallpaper.BlueStarsBox
import net.maiatoday.giith.ui.BlueyBlack
import net.maiatoday.giith.ui.DishwashingLiquid
import net.maiatoday.giith.ui.MyPonyHair
import net.maiatoday.giith.ui.SummerSky
import net.maiatoday.giith.ui.components.Baby
import net.maiatoday.giith.ui.components.Hot
import net.maiatoday.giith.ui.components.New
import openBrowser
import supportsGifs

@Composable
fun MyBookmarksScreen() {
    BlueStarsBox {
        Box(
            modifier = Modifier
                .padding(48.dp)
                .background(brush = SolidColor(BlueyBlack), alpha = 0.5f)
                .fillMaxSize()
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Baby(show = supportsGifs())
                    Text("My Bookmarks", style = MaterialTheme.typography.titleLarge, color = DishwashingLiquid)
                    Baby(show = supportsGifs())
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    BookmarkList(modifier = Modifier.weight(1f), title = "1980s", links = History)
                    BookmarkList(modifier = Modifier.weight(1f), title = "1990s", links = Inspiration)
                    BookmarkList(modifier = Modifier.weight(1f), title = "2023", links = Tools)
                }
            }
        }
    }
}

@Composable
fun BookmarkList(modifier: Modifier = Modifier, title: String, links: List<Bookmark>) {
    LazyColumn(modifier) {
        item {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MyPonyHair
            )
        }
        for (l in links) {
            item {
                LinkItem(l)
            }
        }
    }
}

@Composable
fun LinkItem(link: Bookmark) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        with(link) {
            Text(
                text = text, modifier = Modifier
                    .clickable { openBrowser(url) },
                style = MaterialTheme.typography.bodyMedium,
                color = SummerSky,
                textDecoration = TextDecoration.Underline
            )
            if (isHot) Hot(supportsGifs())
            if (isNew) New(supportsGifs())
        }
    }
}

data class Bookmark(val text: String, val url: String, val isHot: Boolean, val isNew: Boolean) {
    fun toMarkDown():String = "[$text]($url)"
}

val Inspiration = listOf(
    Bookmark(text = "Cameron's World", url = "https://www.cameronsworld.net/", isHot = true, isNew = true),
    Bookmark(text = "Gifcities", url = "https://gifcities.org/", isHot = false, isNew = false),
    Bookmark(
        text = "Web safe colours",
        url = "https://www.rapidtables.com/web/color/Web_Safe.html", isHot = false, isNew = false
    ),
    Bookmark(
        text = "Browser History", url = "https://en.wikipedia.org/wiki/History_of_the_web_browser",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "Free tiling backgrounds",
        url = "https://1-background.com/stars_1.htm",
        isHot = false,
        isNew = false
    ),
    Bookmark(text = "90s cursor effects", url = "https://tholman.com/cursor-effects/", isHot = false, isNew = false),
    Bookmark(
        text = "Dancing baby history",
        url = "https://en.wikipedia.org/wiki/Dancing_baby",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "Groove is in the Heart", url = "https://en.wikipedia.org/wiki/Groove_Is_in_the_Heart",
        isHot = false,
        isNew = false
    ),
    Bookmark(text = "Geocities Torrent", url = "https://blog.geocities.institute/", isHot = true, isNew = false),
    Bookmark(
        text = "Old browser emulators", url = "https://oldweb.today/?browser=ns3-mac#http://geocities.com/",
        isHot = true,
        isNew = false
    ),
)

val Tools = listOf(
    Bookmark(
        text = "Github for this project",
        url = "https://github.com/maiatoday/GrooveIsInTheHeart",
        isHot = false,
        isNew = true
    ),
    Bookmark(text = "Maia's website", url = "https://maiatoday.net", isHot = false, isNew = false),
    Bookmark(
        text = "Cheesy 90s playlist", url = "https://open.spotify.com/playlist/0u9TVKOBdWxcdhPlINVBDD?nd=1",
        isHot = true,
        isNew = false
    ),
    Bookmark(
        text = "Poisson Disk Sampling",
        url = "https://www.jasondavies.com/poisson-disc/",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        "Jetpack Compose animation", "https://developer.android.com/jetpack/compose/animation",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "Compose Multiplatform", url = "https://github.com/JetBrains/compose-multiplatform",
        isHot = false,
        isNew = true
    ),
    Bookmark(
        text = "How to handle resources in Compose multiplatform",
        url = "https://www.netguru.com/blog/kotlin-multiplatform-resources",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "Compose multiplatform sample projects",
        url = "https://github.com/JetBrains/compose-multiplatform/blob/master/examples/README.md",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "Made with compose sample", url = "https://twitter.com/halilozercan/status/1541792011539431424?lang=en",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "Brushing up on Compose Text coloring",
        url = "https://medium.com/androiddevelopers/brushing-up-on-compose-text-coloring-84d7d70dd8fa",
        isHot = true,
        isNew = false
    ),
    Bookmark(
        text = "Make body language of your design by using Animation",
        url = "https://uxdesign.cc/animation-dbc6c0198c04",
        isHot = false,
        isNew = true
    ),
)

val History = listOf(
    Bookmark(text = "Memphis Design Museum", url = "https://designmuseum.org/memphis#", isHot = true, isNew = false),
    Bookmark(
        text = "Memphis Design" +
                "n", url = "https://99designs.com/blog/design-history-movements/memphis-design/",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "Memphis Design influences",
        url = "https://artincontext.org/memphis-design/",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "Ettore Sottsass",
        url = "https://en.wikipedia.org/wiki/Ettore_Sottsass",
        isHot = false,
        isNew = false
    ),
    Bookmark(text = "History of GIF", url = "https://en.wikipedia.org/wiki/GIF", isHot = false, isNew = false),
    Bookmark(text = "Troll doll", url = "https://en.wikipedia.org/wiki/Troll_doll", isHot = false, isNew = false),
    Bookmark(
        text = "My little pony in the 80s",
        url = "https://www.youtube.com/watch?v=kj6_ozMntpU", isHot = false, isNew = false
    ),
    Bookmark(
        text = "How to solve a Rubik's cube", url = "https://www.speedcube.com.au/pages/how-to-solve-a-rubiks-cube",
        isHot = false,
        isNew = false
    ),
    Bookmark(
        text = "The origin of the 80s aesthetic",
        url = "https://youtu.be/TCI8lPvr6SM",
        isHot = true,
        isNew = false
    ),
)


