package net.maiatoday.giith.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import isAndroid
import net.maiatoday.giith.ui.imageResourcePainter
import org.jetbrains.compose.animatedimage.Blank
import org.jetbrains.compose.animatedimage.animate
import org.jetbrains.compose.animatedimage.loadResourceAnimatedImage
import org.jetbrains.compose.resources.loadOrNull

@Composable
fun Troll(showError:Boolean = true, size: Dp = 100.dp) = GifWrap("drawable/troll.gif", showError, size)

@Composable
fun Pony(showError:Boolean = true, size: Dp = 100.dp) = GifWrap("drawable/pony.gif", showError, size)

@Composable
fun ConstructionWorker(showError:Boolean = false, size: Dp = 100.dp) = GifWrap("drawable/construction.gif", showError, size)

@Composable
fun Flame(showError:Boolean = false, size: Dp = 100.dp) = GifWrap("drawable/flame4.gif", showError, size)

@Composable
fun Baby(showError:Boolean = false, size: Dp = 100.dp) = GifWrap("drawable/baby.gif", showError, size)

@Composable
fun Cube(showError:Boolean = false, size: Dp = 100.dp) = GifWrap("drawable/cube.gif", showError, size)

@Composable
fun Hot(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/hot.gif", showError, size)

@Composable
fun New(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/newroller.gif", showError, size)

@Composable
fun Wand(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/capwand.gif", showError, size)

@Composable
fun DancerGirlRainbow(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/dancergirlrainbow.gif", showError, size)

@Composable
fun Pyramid(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/firepyramid.gif", showError, size)

@Composable
fun FlashingGhost(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/flashingghost.gif", showError, size)

@Composable
fun GuestBook(showError:Boolean = false, size: Dp = 100.dp) = GifWrap("drawable/guestbook2better.gif", showError, size)

@Composable
fun Netscape(showError:Boolean = false, size: Dp = 100.dp) = GifWrap("drawable/netscape.gif", showError, size)

@Composable
fun Number0(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/number0.gif", showError, size)

@Composable
fun Rainbow(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/rainbow.gif", showError, size)

@Composable
fun StarSpin(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/starsspin.gif", showError, size)

@Composable
fun New1(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/new1.gif", showError, size)

@Composable
fun Link2(showError:Boolean = false, size: Dp = 48.dp) = GifWrap("drawable/link2.gif", showError, size)

@Composable
fun NetscapeLogo(showError:Boolean = false, size: Dp = 100.dp) = GifWrap("drawable/netscape.gif", showError, size)

@Composable
fun GifWrap(gifResource: String, showError:Boolean = true, size: Dp = 100.dp) {
    if (isAndroid()) {
        if (showError) {
            val brokenFile = imageResourcePainter("bork.png")
            Image(
                modifier = Modifier.size(size),
                painter = brokenFile,
                contentDescription = "Broken file"
            )
        }
    } else {
        Image(
            loadOrNull { loadResourceAnimatedImage(gifResource) }?.animate() ?: ImageBitmap.Blank,
            contentDescription = null,
            Modifier.size(size)
        )
    }

}