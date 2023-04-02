package net.maiatoday.giith.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.animatedimage.Blank
import org.jetbrains.compose.animatedimage.animate
import org.jetbrains.compose.animatedimage.loadAnimatedImage
import org.jetbrains.compose.animatedimage.loadResourceAnimatedImage
import org.jetbrains.compose.resources.loadOrNull

private val dragonGif =
    "https://raw.githubusercontent.com/JetBrains/skija/ccf303ebcf926e5ef000fc42d1a6b5b7f1e0b2b5/examples/scenes/images/codecs/animated.gif"

private val babyGif = "https://web.archive.org/web/20090830200257im_/http://www.geocities.com/sanjhapunjab/babyjatt.gif"

@Composable
fun AnimatedImageLoader(url:String = babyGif) {
    Column {
//        // Load an image async
//        // use "load { loadResourceAnimatedImage(url) }" for resources
//        when (val animatedImage = load { loadAnimatedImage(url) }) {
//            is LoadState.Success -> Image(
//                bitmap = animatedImage.value.animate(),
//                contentDescription = null,
//            )
//            is LoadState.Loading -> CircularProgressIndicator()
//            is LoadState.Error -> Text("Error!")
//        }

        Image(
            loadOrNull { loadAnimatedImage(url) }?.animate() ?: ImageBitmap.Blank,
            contentDescription = null,
            Modifier.size(100.dp)
        )
    }
}

@Composable
fun Troll() {
    Image(
        loadOrNull { loadResourceAnimatedImage("images/troll.gif") }?.animate() ?: ImageBitmap.Blank,
        contentDescription = null,
        Modifier.size(100.dp)
    )
}

@Composable
fun Pony() {
    Image(
        loadOrNull { loadResourceAnimatedImage("images/pony.gif") }?.animate() ?: ImageBitmap.Blank,
        contentDescription = null,
        Modifier.size(100.dp)
    )
}

@Composable
fun ConstructionWorker() {
    Image(
        loadOrNull { loadResourceAnimatedImage("images/construction.gif") }?.animate() ?: ImageBitmap.Blank,
        contentDescription = null,
        Modifier.size(100.dp)
    )
}

@Composable
fun Flame() {
    Image(
        loadOrNull { loadResourceAnimatedImage("images/flame4.gif") }?.animate() ?: ImageBitmap.Blank,
        contentDescription = null,
        Modifier.size(100.dp)
    )
}