import java.awt.Color
import java.awt.Graphics2D
import javax.swing.JFrame

object Window : JFrame(), Runnable {

    private var isRunning = true
    private var stateGame = true
    private val keyListener = KL()
    private val mouseListener = ML()

    init {
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)
        title = Constants.SCREEN_TITLE
        isResizable = true
        isVisible = true
        defaultCloseOperation = EXIT_ON_CLOSE

        addKeyListener(keyListener)
        addMouseListener(mouseListener)
        addMouseMotionListener(mouseListener)

        Constants.TOOLBAR_HEIGHT = insets.top.toDouble()
        Constants.INSETS_HEIGHT = insets.bottom.toDouble()
    }

    private val game = Game(keyListener, ::changeStateGame)
    private val menu = MainMenu(mouseListener, ::changeStateGame, ::stop)

    private fun changeStateGame() {
        stateGame = !stateGame
    }

    private fun update(dt: Double) {
//        println("${1 / dt} fps")
        val dbImage = createImage(width, height)
        val dbg = dbImage.graphics as Graphics2D
        draw(dbg)

        val g2 = graphics as Graphics2D
        g2.drawImage(dbImage, 0, 0, this)

        if (stateGame) {
            menu.update(dt)
        } else {
            game.update(dt)
        }
    }

    private fun draw(graphics2D: Graphics2D) {
        graphics2D.color = Color.BLACK
        graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)

        if (stateGame) {
            menu.draw(graphics2D)
        } else {
            game.draw(graphics2D)
        }

    }

    private fun stop() {
        isRunning = false
    }


    override fun run() {

        var lastTimeFrame = 0.0

        while (isRunning) {
            val time = Time.getTime()
            val deltaTime = time - lastTimeFrame
            lastTimeFrame = time

            update(deltaTime)
        }

        dispose()
        return
    }
}