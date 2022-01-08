import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D

class Text(var text: String, private val font: Font, val x: Double, val y: Double, var color: Color = Color.WHITE) {

    val width = font.size * text.length
    val height = font.size

    fun draw(graphics2D: Graphics2D) {
        graphics2D.color = color
        graphics2D.font = font
        graphics2D.drawString(text, x.toFloat(), y.toFloat())
    }
}