import pt.isel.canvas.*


fun main() {
    onStart {
        val arena = Canvas(width = 800, height = 400, background = WHITE)
        var stone = Stone( center = Point(0,0) )
        arena.onMouseDown { me: MouseEvent ->
            stone = createStone(me.x,me.y)
            arena.erase()
            arena.drawStone(stone)
        }
        arena.onTimeProgress(50) {
            stone = stone.timePass(50)
            if (stone.time<=0)
                arena.erase()
        }
    }
    onFinish { }
}