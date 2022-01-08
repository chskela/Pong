import java.awt.Color
import kotlin.properties.Delegates

object Constants {
    // Screen
    const val SCREEN_WIDTH = 800
    const val SCREEN_HEIGHT = 600
    const val SCREEN_TITLE = "Pong"

    var TOOLBAR_HEIGHT by Delegates.notNull<Double>()
    var INSETS_HEIGHT by Delegates.notNull<Double>()

    // Paddle
    const val PADDLE_WIDTH = 15.0
    const val PADDLE_HEIGHT = 100.0
    const val PADDLE_SPEED = 250.0
    val PADDLE_COLOR: Color = Color.WHITE

    // Ball
    const val BALL_DIAMETER = 10.0
    const val BALL_SPEED = 200.0
    const val MAX_ANGLE = 45.0
    val BALL_COLOR: Color = Color.WHITE

    // Padding
    const val HZ_PADDING = 40.0

    // Font
    const val FONT = "Roboto"

    // Text
    const val TEXT_Y_POS = 70.0
    const val TEXT_X_POS = 70.0
    const val TEXT_SIZE = 40

    // Game
    const val WIN_SCORE = 11
}