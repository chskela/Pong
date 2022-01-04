import java.awt.Color
import java.awt.Graphics2D

class Rect(
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int,
    private val color: Color
) {
    fun draw(graphics2D: Graphics2D) {
        graphics2D.color = color
        graphics2D.fillRect(x, y, width, height)
    }
}