package net.maiatoday.giith.navigation.roots

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.blink.BlinkText
import net.maiatoday.giith.gaudydivider.ShimmerDivider
import net.maiatoday.giith.glitter.GlitterBox
import net.maiatoday.giith.heartpath.CandyHeartPulse
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.Screen.*
import net.maiatoday.giith.rainbowtext.GradientTextShimmer
import net.maiatoday.giith.rainbowtext.MultiColorSmoothText
import net.maiatoday.giith.rainbowtext.SnappyRainbowText
import net.maiatoday.giith.ui.*
import net.maiatoday.giith.ui.components.*
import net.maiatoday.giith.underconstruction.Chevron
import net.maiatoday.giith.visitorcounter.Counter

@Composable
fun HomeScreen(
    groovy: Boolean = false,
    switchChildScreen: (screen: Screen) -> Unit = {}
) {
    if (groovy) GroovyHome(switchChildScreen = switchChildScreen)
    else SimpleHome(switchChildScreen = switchChildScreen)
}

@Composable
fun SimpleHome(modifier: Modifier = Modifier, switchChildScreen: (screen: Screen) -> Unit = {}) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            for (s in Screen.values()) {
                if (s !in listOf(Home, GuestBook, MyBookmarks)) {
                    Button(onClick = { switchChildScreen(s) }) {
                        Text(s.toString())
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GroovyHome(modifier: Modifier = Modifier, switchChildScreen: (screen: Screen) -> Unit = {}) {
    Surface(modifier = modifier.fillMaxSize()) {
        UltraVioletBox()
        Box(
            modifier = Modifier
                .padding(64.dp)
                .alpha(0.7f)
                .background(color = BlueyBlack)
        )
        Box(
            modifier = Modifier
                .padding(64.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Pony()
                    Baby()
                    GradientTextShimmer(
                        text = "Welcome to my corner of the Internet",
                        style = MaterialTheme.typography.headlineMedium,
                        colors = vividRainbow
                    )
                    Baby()
                    Pony()
                }
                ShimmerDivider(height = 8.dp, colors = vividRainbow)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    for (s in Screen.values()) {
                        if (s != Home) {
                            item {
                                Row(
                                    Modifier
                                        .border(width = 2.dp, color = MyPonyHair)
                                        .clickable { switchChildScreen(s) }
                                        .padding(8.dp)
                                ) {
                                    GifForScreen(s)
                                    Text(
                                        modifier = Modifier
                                            .padding(8.dp),
                                        text = s.toString(),
                                        textDecoration = TextDecoration.Underline
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Chevron(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GuestBook()
                    BlinkText(
                        text = "Sign the Guest Book",
                        color = Lime,
                        modifier = Modifier
                            .clickable { switchChildScreen(Screen.GuestBook) }
                            .padding(8.dp),
                        style = MaterialTheme.typography.headlineMedium,
                        durationMillis = 2000,
                        textDecoration = TextDecoration.Underline
                    )
                    ConstructionWorker()
                    BlinkText(
                        text = "My Bookmarks",
                        color = SummerSky,
                        modifier = Modifier
                            .clickable { switchChildScreen(Screen.MyBookmarks) }
                            .padding(8.dp),
                        style = MaterialTheme.typography.headlineMedium,
                        durationMillis = 2000,
                        textDecoration = TextDecoration.Underline
                    )
                    Link2()
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NetscapeLogo()
                    VisitorCounterFake()
                    ComposeLogo()
                }
            }
        }
        GlitterBox(rainbow = pastelRainbow)
    }
}

@Composable
fun GifForScreen(screen: Screen) {
    when (screen) {
        Home -> {}
        ColorSwatches -> Troll(size = 48.dp, showError = false)
        Wallpaper -> Hot()
        Memphis -> Pyramid()
        Stars -> StarSpin()
        Blink -> FlashingGhost()
        RainbowText -> Rainbow()
        VisitorCounter -> Number0()
        GlitterPointer -> Wand()
        HeartPath -> DancerGirlRainbow()
        UnderConstruction -> Flame(size = 48.dp)
        GuestBook -> GuestBook(size = 48.dp)
        MyBookmarks -> Link2()
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun VisitorCounterFake() {
    var count by remember { mutableStateOf(12910) }
    Row(modifier = Modifier
        .wrapContentSize()
        .clickable { count++ }
        .border(width = 2.dp, color = Lint)
        .padding(8.dp)) {
        Column {
            MultiColorSmoothText(text = "Visitors", duration = 1000)
            Counter(count = count, width = 8, onClick = {})
            SnappyRainbowText(text = "Stay Groovy")
        }
        Box(modifier = Modifier.size(65.dp)) {
            CandyHeartPulse(initialValue = 0.2f, targetValue = 0.8f)
        }
    }
}