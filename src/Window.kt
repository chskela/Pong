import javax.swing.JFrame

object Window : JFrame(), Runnable {

init {
    setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)
    title = Constants.SCREEN_TITLE
    isResizable = true
    isVisible = true
    defaultCloseOperation = EXIT_ON_CLOSE
}

    override fun run() {
        while (true) {

        }
    }
}