object Time {
    val timeStarted = System.nanoTime()

    fun getTime() = (System.nanoTime() - timeStarted) * 1E-9
}