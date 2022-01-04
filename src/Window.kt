import java.awt.Color
import java.awt.Graphics2D
import javax.swing.JFrame

object Window : JFrame(), Runnable {

    private val keyListener = KL()
    private var g2: Graphics2D
    var player: Rect
    var ai: Rect
    var ball: Rect

    init {
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)
        title = Constants.SCREEN_TITLE
        isResizable = true
        isVisible = true
        defaultCloseOperation = EXIT_ON_CLOSE

        addKeyListener(keyListener)

        g2 = graphics as Graphics2D

        player = Rect(
            Constants.HZ_PADDING,
            40, Constants.PADDLE_WIDTH,
            Constants.PADDLE_HEIGHT,
            Constants.PADDLE_COLOR
        )

        ai = Rect(
            Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH - Constants.HZ_PADDING,
            40,
            Constants.PADDLE_WIDTH,
            Constants.PADDLE_HEIGHT,
            Constants.PADDLE_COLOR
        )

        ball = Rect(
            Constants.SCREEN_WIDTH / 2,
            Constants.SCREEN_HEIGHT / 2,
            Constants.BALL_DIAMETER,
            Constants.BALL_DIAMETER,
            Constants.BALL_COLOR
        )
    }

    private fun update(dt: Double) {
//        println("${1 / dt} fps")
        g2.color = Color.BLACK
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)

        player.draw(g2)
        ai.draw(g2)
        ball.draw(g2)
    }

    override fun run() {

        var lastTimeFrame = 0.0

        while (true) {
            val time = Time.getTime()
            val deltaTime = time - lastTimeFrame
            lastTimeFrame = time

            try {
                Thread.sleep(30)
            } catch (e: Exception) {
                println(e)
            }

            update(deltaTime)
        }
    }
}