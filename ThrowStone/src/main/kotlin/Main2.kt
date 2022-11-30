import pt.isel.canvas.*

/**
 * Displays the stone at the clicked location.
 * The stone disappears after a while.
 */
fun main() {
    onStart {
        val arena = Canvas(width = 800, height = 400, background = WHITE)
        var stone: Stone? = null
        arena.onMouseDown { me: MouseEvent ->
            stone = createStone(me.x,me.y)
            arena.erase()
            arena.drawStone(stone)
        }
        arena.onTimeProgress(50) {
            stone = stone?.timePass(50)
            if (stone==null) arena.erase()
        }
    }
    onFinish { }
}