import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import javax.swing.JFrame

object Window : JFrame(), Runnable {

    private val keyListener = KL()

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


    init {
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)
        title = Constants.SCREEN_TITLE
        isResizable = true
        isVisible = true
        defaultCloseOperation = EXIT_ON_CLOSE

        addKeyListener(keyListener)
        Constants.TOOLBAR_HEIGHT = insets.top.toDouble()
        Constants.INSETS_HEIGHT = insets.bottom.toDouble()
    }

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

    private val ballController = BallController(ball, player, ai, leftScoreText, rightScoreText)

    private fun update(dt: Double) {
//        println("${1 / dt} fps")
        val dbImage = createImage(width, height)
        val dbg = dbImage.graphics as Graphics2D
        val g2 = graphics as Graphics2D
        draw(dbg)
        g2.drawImage(dbImage, 0, 0, this)


        ballController.update(dt)
        aiController.update(dt)
        playerController.update(dt)

    }

    private fun draw(graphics2D: Graphics2D) {
        graphics2D.color = Color.BLACK
        graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)

        val font = Font(Constants.FONT, Font.PLAIN, 14)
        val text = Text("Sample", font, 100.0, 100.0)
        text.draw(graphics2D)
        leftScoreText.draw(graphics2D)
        rightScoreText.draw(graphics2D)

        player.draw(graphics2D)
        ai.draw(graphics2D)
        ball.draw(graphics2D)
    }

    override fun run() {

        var lastTimeFrame = 0.0

        while (true) {
            val time = Time.getTime()
            val deltaTime = time - lastTimeFrame
            lastTimeFrame = time

            update(deltaTime)
        }
    }
}