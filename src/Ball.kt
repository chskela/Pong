class Ball(private val ball: Rect, private val leftPaddle: Rect, private val rightPaddle: Rect) {
    private var vy = 150.0
    private var vx = -100.0

    fun update(dt: Double) {

        if (vx < 0) {
            if (ball.y in leftPaddle.y..leftPaddle.y + leftPaddle.height
                && ball.x in leftPaddle.x..leftPaddle.x + leftPaddle.width
            ) {
                vx *= -1
            } else if (ball.x < leftPaddle.x) {
                println("PL loose")
            }
        }

        if (vx > 0) {
            if (ball.y in rightPaddle.y..rightPaddle.y + rightPaddle.height
                && ball.x in rightPaddle.x..rightPaddle.x + rightPaddle.width
            ) {
                vx *= -1
            } else if (ball.x > rightPaddle.x + rightPaddle.width) {
                println("AI loose")
            }
        }

        if (vy > 0) {
            if (ball.y + ball.height >= Constants.SCREEN_HEIGHT - Constants.INSETS_HEIGHT) {
                vy *= -1
            }
        }

        if (vy < 0) {
            if (ball.y <= Constants.TOOLBAR_HEIGHT ) {
                vy *= -1
            }
        }


        ball.x += vx * dt
        ball.y += vy * dt

    }
}