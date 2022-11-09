import pt.isel.canvas.*

private const val STONE_SIZE = 100

data class Stone(val x: Int, val y: Int, val size: Int, val time: Int)

fun Stone.move(x: Int, y: Int) = copy(x = x, y = y, time = 2000)

fun Canvas.drawStone(s: Stone) {
    drawImage("stone",s.x-s.size/2,s.y-s.size/2,s.size,s.size)
}

fun main() {
    onStart {
        val arena = Canvas(800,400,WHITE)
        var stone = Stone(0,0,STONE_SIZE,0)
        arena.onMouseDown { me: MouseEvent ->
            stone = stone.move(me.x,me.y)
            arena.erase()
            arena.drawStone(stone)
        }
        arena.onTimeProgress(50) {
            if (stone.time<=0)
                arena.erase()
            else {
                stone = stone.copy(time = stone.time - 50)
                println(stone.time)
            }
        }
    }
    onFinish { }
}