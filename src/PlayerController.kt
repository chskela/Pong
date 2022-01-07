import java.awt.event.KeyEvent

open class PlayerController(protected val rect: Rect, private val keyListener: KL? = null) {

    open fun update(dt: Double) {
        if (keyListener != null) {
            if (keyListener.isKeyPressed(KeyEvent.VK_DOWN) ) {
                moveDown(dt)
            } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
                moveUp(dt)
            }
        }

    }

    fun moveUp(dt: Double) {
        if (rect.y > Constants.TOOLBAR_HEIGHT) {
            rect.y -= Constants.PADDLE_SPEED * dt
        }
    }

    fun moveDown(dt: Double) {
        if (rect.y < Constants.SCREEN_HEIGHT - Constants.PADDLE_HEIGHT - Constants.INSETS_HEIGHT
        ) {
            rect.y += Constants.PADDLE_SPEED * dt
        }
    }
}