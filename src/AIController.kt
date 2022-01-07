class AIController(rect: Rect, private val ball: Rect) : PlayerController(rect) {
    override fun update(dt: Double) {
//        super.update(dt)
        if (ball.y < rect.y) {
            super.moveUp(dt)
        }

        if (ball.y > rect.y + rect.height) {

            super.moveDown(dt)
        }
    }
}