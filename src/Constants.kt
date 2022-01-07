import java.awt.Color
import kotlin.properties.Delegates

object Constants {
    // Screen
    const val SCREEN_WIDTH = 800
    const val SCREEN_HEIGHT = 600
    const val SCREEN_TITLE = "Pong"

    var TOOLBAR_HEIGHT by Delegates.notNull<Int>()
    var INSETS_HEIGHT by Delegates.notNull<Int>()

    // Paddle
    const val PADDLE_WIDTH = 15.0
    const val PADDLE_HEIGHT = 100.0
    const val PADDLE_SPEED = 250.0
    val PADDLE_COLOR: Color = Color.WHITE

    // Ball
    const val BALL_DIAMETER = 10.0
    val BALL_COLOR: Color = Color.WHITE

    // Padding
    const val HZ_PADDING = 40.0
}