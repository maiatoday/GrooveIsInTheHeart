package net.maiatoday.giith.navigation

sealed class Screen {
    object Home : Screen()
    object ColorSwatches : Screen()
    object DoodleSketch : Screen()
    object RainbowText : Screen()
    object Blink : Screen()
    object VisitorCounter : Screen()
    object GlitterPointer : Screen()
    object UnderConstruction : Screen()
    object HeartPath : Screen()
    object Links : Screen()
    object GuestBook : Screen()
}

data class ChildScreen(val name: String = "", val screen: Screen)
