import pt.isel.canvas.*

const val NUMBER_OF_MONSTERS = 10

fun main() {
    onStart {
        val arena = Canvas(width = 800, height = 400, background = WHITE)
        var monsters = List(NUMBER_OF_MONSTERS) {
            createMonster(arena.width, arena.height)
        }
        monsters.forEach { it.drawIn(arena) }
        arena.onTimeProgress(UPDATE_TIME) {
            monsters = monsters.map { it.randomMove(arena.width, arena.height)}
            arena.erase()
            monsters.forEach { it.drawIn(arena) }
        }
        arena.onMouseDown { me ->
            monsters = monsters.map { it.touch( Point(me.x,me.y) ) }
        }
    }
    onFinish { }
}