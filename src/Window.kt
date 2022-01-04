import java.awt.Color
import java.awt.Graphics2D
import java.awt.event.KeyEvent
import javax.swing.JFrame

object Window : JFrame(), Runnable {

    private val keyListener = KL()

    init {
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)
        title = Constants.SCREEN_TITLE
        isResizable = true
        isVisible = true
        defaultCloseOperation = EXIT_ON_CLOSE
        addKeyListener(keyListener)
    }

    private val g2 = graphics as Graphics2D

    private fun update(dt: Double) {
//        println("${1 / dt} fps")
        g2.color = Color.BLACK
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)

        if (keyListener.isPressed(KeyEvent.VK_UP)) {
            println("UP")
        }
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