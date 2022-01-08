import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener

class ML(private var isPressed: Boolean = false, private var x: Double = 0.0, private var y: Double = 0.0) :
    MouseAdapter(), MouseMotionListener {

    override fun mousePressed(e: MouseEvent?) {
        isPressed = true
    }

    override fun mouseReleased(e: MouseEvent?) {
        isPressed = false
    }

    override fun mouseMoved(e: MouseEvent?) {
        if (e != null) {
            x = e.x.toDouble()
            y = e.y.toDouble()
        }
    }

    fun getMouseX() = x
    fun getMouseY() = y
    fun isMousePressed() = isPressed
}
