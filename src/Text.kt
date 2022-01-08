import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D

class Text(var text: String, private val font: Font, private val x: Double, private val y: Double) {

    fun draw(graphics2D: Graphics2D) {
        graphics2D.color = Color.WHITE
        graphics2D.font = font
        graphics2D.drawString(text, x.toFloat(), y.toFloat())
    }
}