import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KL : KeyListener {
    private val keyPressed = BooleanArray(128)

    override fun keyTyped(e: KeyEvent?) {
        TODO("Not yet implemented")
    }

    override fun keyPressed(e: KeyEvent?) {
        if (e != null) {
            keyPressed[e.keyCode] = true
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        if (e != null) {
            keyPressed[e.keyCode] = false
        }
    }

    fun isPressed(key: Int): Boolean = keyPressed[key]
}