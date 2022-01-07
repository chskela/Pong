class AIController(rect: Rect, private val ball: Rect) : PlayerController(rect) {
    override fun update(dt: Double) {
//        super.update(dt)
        if (ball.y < rect.y) {
            moveUp(dt)
        }

        if (ball.y + ball.height > rect.y + rect.height) {
            moveDown(dt)
        }
    }
}