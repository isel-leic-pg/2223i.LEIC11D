import pt.isel.canvas.Canvas

private const val STONE_SIZE = 100

data class Stone(val center: Point, val time: Int = 0)

fun createStone(x: Int, y: Int) = Stone(center = Point(x,y), time = 2000)

fun Stone.timePass(t: Int): Stone =
    if (time > 0) copy(time = time-t) else this

fun Canvas.drawStone(s: Stone) {
    drawImage("stone",s.center.x-STONE_SIZE/2,s.center.y-STONE_SIZE/2,STONE_SIZE,STONE_SIZE)
}
