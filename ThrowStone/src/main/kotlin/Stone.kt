import pt.isel.canvas.Canvas

private const val STONE_SIZE = 100

data class Stone(val center: Point, val time: Int = 0)

fun createStone(x: Int, y: Int) = Stone(center = Point(x,y), time = 2000)

fun Stone.timePass(t: Int): Stone? {
    //return if (time > 0) copy(time = time-t) else null
    val tm = time-t
    return if(tm<=0) null else copy(time=tm)
}

fun Canvas.drawStone(s: Stone?) {
    if (s!=null)
        drawImage("stone",s.center.x-STONE_SIZE/2,s.center.y-STONE_SIZE/2,STONE_SIZE,STONE_SIZE)
}
