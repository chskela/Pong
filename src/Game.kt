import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D

class Game(keyListener: KL, setState: () -> Unit ) {

    private val player = Rect(
        Constants.HZ_PADDING,
        40.0, Constants.PADDLE_WIDTH,
        Constants.PADDLE_HEIGHT,
        Constants.PADDLE_COLOR
    )

    private val ai = Rect(
        Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH - Constants.HZ_PADDING,
        40.0,
        Constants.PADDLE_WIDTH,
        Constants.PADDLE_HEIGHT,
        Constants.PADDLE_COLOR
    )

    private val ball = Rect(
        Constants.SCREEN_WIDTH.toDouble() / 2,
        Constants.SCREEN_HEIGHT.toDouble() / 2,
        Constants.BALL_DIAMETER,
        Constants.BALL_DIAMETER,
        Constants.BALL_COLOR
    )

    private val playerController = PlayerController(player, keyListener)
    private val aiController = AIController(ai, ball)

    private var leftScoreText =
        Text(
            "0",
            Font(Constants.FONT, Font.PLAIN, Constants.TEXT_SIZE),
            Constants.TEXT_X_POS,
            Constants.TOOLBAR_HEIGHT + Constants.TEXT_Y_POS
        )

    private var rightScoreText = Text(
        "0",
        Font(Constants.FONT, Font.PLAIN, Constants.TEXT_SIZE),
        Constants.SCREEN_WIDTH - Constants.TEXT_X_POS - Constants.TEXT_SIZE,
        Constants.TOOLBAR_HEIGHT + Constants.TEXT_Y_POS
    )

    private val ballController = BallController(ball, player, ai, leftScoreText, rightScoreText, setState)

    fun draw(graphics2D: Graphics2D) {
        graphics2D.color = Color.BLACK
        graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)

        leftScoreText.draw(graphics2D)
        rightScoreText.draw(graphics2D)

        player.draw(graphics2D)
        ai.draw(graphics2D)
        ball.draw(graphics2D)
    }

    fun update(dt: Double) {
        ballController.update(dt)
        aiController.update(dt)
        playerController.update(dt)
    }

}