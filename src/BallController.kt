import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sign
import kotlin.math.sin

class BallController(
    private val ball: Rect,
    private val leftPaddle: Rect,
    private val rightPaddle: Rect,
    private val leftScoreText: Text,
    private val rightScoreText: Text
) {
    private var vy = 20.0
    private var vx = -180.0

    fun update(dt: Double) {
        val dx = vx * dt
        val dy = vy * dt

        if (vx < 0.0) {
            if (ball.x + dx in getRangeX(leftPaddle)) {
                if (ball.y + dy in getRangeY(leftPaddle, ball)) {
                    val (newVx, newVy) = calculateVelocity(leftPaddle)
                    vx = newVx * -1.0 * sign(vx)
                    vy = newVy
                }
            } else if (ball.x < leftPaddle.x) {
                println("PL loose")
            }
        }

        if (vx >= 0.0) {
            if (ball.x + ball.width + dx in getRangeX(rightPaddle)) {
                if (ball.y + dy in getRangeY(rightPaddle, ball)) {
                    val (newVx, newVy) = calculateVelocity(rightPaddle)
                    vx = newVx * -1.0 * sign(vx)
                    vy = newVy
                }
            } else if (ball.x > rightPaddle.x + rightPaddle.width) {
                println("AI loose")
            }
        }

        if (vy >= 0.0) {
            if (ball.y + dy + ball.height >= Constants.SCREEN_HEIGHT - Constants.INSETS_HEIGHT) {
                vy *= -1
            }
        }

        if (vy < 0.0) {
            if (ball.y + dy <= Constants.TOOLBAR_HEIGHT) {
                vy *= -1
            }
        }

        ball.x += dx
        ball.y += dy

        if (ball.x + ball.width < leftPaddle.x) {
            rightScoreText.text = (rightScoreText.text.toIntOrNull() ?: 0).inc().toString()
            setStartPosition()
            if ((rightScoreText.text.toIntOrNull() ?: 0) >= Constants.WIN_SCORE) {
                println("Win AI")
            }
        }

        if (ball.x > rightPaddle.x + rightPaddle.width) {
            leftScoreText.text = (leftScoreText.text.toIntOrNull() ?: 0).inc().toString()
            setStartPosition()
            if ((leftScoreText.text.toIntOrNull() ?: 0) >= Constants.WIN_SCORE) {
                println("Win player")
            }
        }
    }

    private fun calculateVelocity(paddle: Rect): Pair<Double, Double> {
        val theta = calculateTheta(paddle)
        val newVx = abs(cos(theta) * Constants.BALL_SPEED)
        val newVy = -sin(theta) * Constants.BALL_SPEED
        return Pair(newVx, newVy)
    }

    private fun calculateTheta(paddle: Rect): Double {
        val relativeIntersectY = paddle.y + paddle.height / 2 - (ball.y + ball.height / 2)
        val normalIntersectY = relativeIntersectY * 2 / paddle.height
        return Math.toRadians(normalIntersectY * Constants.MAX_ANGLE)
    }

    private fun getRangeX(paddle: Rect) = paddle.x..paddle.x + paddle.width

    private fun getRangeY(paddle: Rect, ball: Rect) = paddle.y - ball.height..paddle.y + paddle.height - ball.height

    private fun setStartPosition() {
        ball.x = (Constants.SCREEN_WIDTH / 2).toDouble()
        ball.y = (Constants.SCREEN_HEIGHT / 2).toDouble()
        vy = 20.0
        vx = -180.0
    }

}