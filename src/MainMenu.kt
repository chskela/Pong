import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D

class MainMenu(private val mouseListener: ML, private val setState: () -> Unit, private val stop: () -> Unit) {

    private val pong =
        Text(
            Constants.PONG,
            Font(Constants.FONT, Font.PLAIN, Constants.TEXT_SIZE * 2),
            Constants.SCREEN_WIDTH / 2.0 - 100.0,
            Constants.TOOLBAR_HEIGHT + 100.0
        )

    private val startGame =
        Text(
            Constants.START_GAME,
            Font(Constants.FONT, Font.PLAIN, Constants.TEXT_SIZE),
            Constants.SCREEN_WIDTH / 2.0 - 110,
            Constants.SCREEN_HEIGHT / 2.0
        )

    private val exitGame = Text(
        Constants.EXIT_GAME,
        Font(Constants.FONT, Font.PLAIN, Constants.TEXT_SIZE),
        Constants.SCREEN_WIDTH / 2.0 - 45,
        Constants.SCREEN_HEIGHT / 2.0 + 60.0
    )

    fun update(dt: Double) {

        if (checkMouseOnText(startGame)
        ) {
            startGame.color = Color.GRAY
            if (mouseListener.isMousePressed()) {
                setState()
            }
        } else {
            startGame.color = Color.WHITE
        }

        if (checkMouseOnText(exitGame)
        ) {
            exitGame.color = Color.GRAY
            if (mouseListener.isMousePressed()) {
                stop()
            }
        } else {
            exitGame.color = Color.WHITE
        }
    }

    fun draw(graphics2D: Graphics2D) {
        pong.draw(graphics2D)
        startGame.draw(graphics2D)
        exitGame.draw(graphics2D)
    }

    private fun checkMouseOnText(text: Text) = (mouseListener.getMouseX() in text.x..text.x + text.width
            && mouseListener.getMouseY() in text.y - text.height / 2..text.y + text.height / 2)
}