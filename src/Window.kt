import javax.swing.JFrame

object Window : JFrame(), Runnable {

init {
    setSize(800, 600)
    title = "Pong"
    isResizable = true
    isVisible = true
    defaultCloseOperation = EXIT_ON_CLOSE
}

    override fun run() {
        while (true) {

        }
    }
}