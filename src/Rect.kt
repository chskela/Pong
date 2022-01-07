import java.awt.Color
import java.awt.Graphics2D
import java.awt.geom.Rectangle2D

class Rect(
    var x: Double,
    var y: Double,
    val width: Double,
    val height: Double,
    private val color: Color
) {
    fun draw(graphics2D: Graphics2D) {
        graphics2D.color = color
        graphics2D.fill(Rectangle2D.Double(x, y, width, height))
    }
}