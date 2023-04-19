package net.maiatoday.giith.demos.i_glitter

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import androidx.compose.ui.unit.toSize
import kotlinx.coroutines.isActive
import net.maiatoday.giith.ui.vividRainbow
import net.maiatoday.giith.demos.i_glitter.GlitterState.Companion.sizeChanged
import net.maiatoday.giith.demos.i_glitter.GlitterState.Companion.updateSource








//region Glitter Fleck object
enum class GlitterShape {
    Mixed,
    Rectangle,
    Circle
}
class Fleck(
    vector: Offset,
    private val glitterColor: Color,
    private val radius: Float,
    private val shape: GlitterShape = GlitterShape.Circle,
    position: Offset
) {
    var lifeCount: Int = MAX_LIFE
    private var drawRadius = radius
    private var position by mutableStateOf(position)
    private var vector by mutableStateOf(vector)
    private val paint: Paint = Paint().apply {
        isAntiAlias = true
        color = glitterColor
        style = PaintingStyle.Fill
    }

    fun next(
        borders: Size,
        durationMillis: Long,
        speedCoefficient: Float
    ) {
        lifeCount -= 1
        if (lifeCount <= 0) lifeCount = 0
        drawRadius = radius * lifeCount / MAX_LIFE
        val speed = vector * speedCoefficient
        val borderTop = 0
        val borderLeft = 0
        val borderBottom = borders.height
        val borderRight = borders.width

        position = Offset(
            x = position.x + (speed.x / 1000f * durationMillis),
            y = position.y + (speed.y / 1000f * durationMillis),
        )
        val vx = if (position.x < borderLeft || position.x > borderRight) -vector.x else vector.x
        val vy = if (position.y < borderTop || position.y > borderBottom) -vector.y else vector.y

        if (vx != vector.x || vy != vector.y) {
            vector = Offset(vx, vy)
        }
    }

    fun draw(canvas: Canvas) {
        if (lifeCount > 0) {
            if (shape == GlitterShape.Circle) {
                canvas.drawCircle(
                    radius = drawRadius,
                    center = position,
                    paint = paint
                )
            } else {
                val rect =
                    Rect(
                        position.x,
                        position.y,
                        position.x + drawRadius,
                        position.y + drawRadius
                    )
                canvas.drawRect(
                    rect = rect,
                    paint = paint
                )
            }
        }
    }

    companion object {
        const val MAX_LIFE = 100
        val radiusRange = (5..25)
        fun create(
            xVectorRange: IntRange,
            yVectorRange: IntRange,
            colors: List<Color>,
            glitterShape: GlitterShape,
            source: Offset = Offset(0f, 0f)
        ): Fleck {
            val shape = if (glitterShape == GlitterShape.Mixed) {
                if ((0..1).random() == 0) GlitterShape.Circle else GlitterShape.Rectangle
            } else glitterShape
            return Fleck(
                position = source,
                vector = Offset(
                    x = listOf(-1f, 1f).random() * xVectorRange.random().toFloat(),
                    y = yVectorRange.random().toFloat()
                ),
                glitterColor = colors.random(),
                radius = radiusRange.random().toFloat(),
                shape = shape
            )
        }
    }
}
//endregion

//region State of all the Glitter Flecks
data class GlitterState(
    val flecks: List<Fleck> = emptyList(),
    val colors: List<Color>,
    val glitterShape: GlitterShape,
    val size: Size = Size.Zero,
    val speed: Float,
    val fleckCount: Int = 10,
    val source: Offset = Offset(0f, 0f)
) {

    private val xVectorRange: IntRange = -100..100
    private val yVectorRange: IntRange = 0..500

    fun next(durationMillis: Long) {
        flecks.forEach {
            it.next(size, durationMillis, speed)
        }
    }

    companion object {
        fun GlitterState.sizeChanged(
            size: Size
        ): GlitterState {
            if (size == this.size) return this
            return copy(
                size = size
            )
        }

        fun GlitterState.updateSource(
            source: Offset
        ): GlitterState {
            if (source == this.source) return this
            return copy(
                flecks = flecks.filter { it.lifeCount > 0 } + (0..fleckCount).map {
                    Fleck.create(
                        xVectorRange,
                        yVectorRange,
                        colors = colors,
                        glitterShape = glitterShape,
                        source
                    )
                },
                source = source
            )
        }
    }
}
//endregion

//region GlitterBox with draggable block that updates state and draws flecks
@Composable
fun GlitterBox(
    rainbow: List<Color> = vividRainbow,
    fleckCount: Int = 2,
    visible: Boolean = true
) {

    var size by remember { mutableStateOf(Size.Zero) }
    var source by remember { mutableStateOf(Offset(200f, 200f)) }
    var glitterState by remember {
        mutableStateOf(
            GlitterState(
                speed = 0.5f,
                colors = rainbow,
                glitterShape = GlitterShape.Mixed,
                fleckCount = fleckCount,
                source = source
            )
        )
    }
    var lastFrame by remember { mutableStateOf(-1L) }

    //region Manual way to update
    LaunchedEffect(visible) {
        while (visible && isActive) {
            withFrameMillis { newTick ->
                val elapsedMillis = newTick - lastFrame
                val wasFirstFrame = lastFrame < 0
                lastFrame = newTick
                if (wasFirstFrame) return@withFrameMillis
                glitterState.next(elapsedMillis)
            }
        }
    }
    //endregion

    Box(
        Modifier
            .fillMaxSize()
            .onSizeChanged { size = it.toSize() }
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            glitterState = glitterState.sizeChanged(this.size)
            if (visible) {
                for (fleck in glitterState.flecks) {
                    fleck.draw(drawContext.canvas)
                }
            }
        }
        Box(
            Modifier
                .offset { source.round() }
                .size(10.dp)
                .background(Color.Magenta)
                .pointerInput(Unit) {
                    detectDragGestures { _, dragAmount ->
                        val summed = source + dragAmount
                        val newValue = Offset(
                            x = summed.x.coerceIn(0f, size.width - 10.dp.toPx()),
                            y = summed.y.coerceIn(0f, size.height - 10.dp.toPx())
                        )
                        source = newValue
                        glitterState = glitterState.updateSource(source)
                    }
                }
        )
    }
}
//endregion