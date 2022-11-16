import pt.isel.canvas.*

/**
 * Shows many monsters moving randomly in the arena.
 * Each monster is crushed when a stone is thrown at it.
 * This implementation is not recommended because it uses two mutability points and the main function becomes too complex.
 */
fun main() {
    onStart {
        val arena = Canvas(width = 800, height = 400, background = WHITE)
        var monsters = List(NUMBER_OF_MONSTERS) {
            createMonster(arena.width, arena.height)
        }
        monsters.forEach { it.drawIn(arena) }
        var stone = Stone( center = Point(0,0) )
        arena.onMouseDown { me: MouseEvent ->
            stone = createStone(me.x,me.y)
            monsters = monsters.map { it.touch( Point(me.x,me.y) ) }
        }
        arena.onTimeProgress(UPDATE_TIME) {
            arena.erase()
            stone = stone.timePass(UPDATE_TIME)
            monsters = monsters.map { it.randomMove(arena.width, arena.height)}
            monsters.forEach { it.drawIn(arena) }
            if (stone.time>0)
                arena.drawStone(stone)
        }
    }
    onFinish { }
}