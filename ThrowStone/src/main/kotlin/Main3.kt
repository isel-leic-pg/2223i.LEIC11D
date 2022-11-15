import pt.isel.canvas.*

const val UPDATE_TIME = 100 // milliseconds

fun main() {
    onStart {
        val arena = Canvas(width = 800, height = 400, background = WHITE)
        var monster = createMonster(arena.width, arena.height)
        monster.drawIn(arena)
        arena.onTimeProgress(UPDATE_TIME) {
            monster = monster.randomMove(arena.width, arena.height)
            arena.erase()
            monster.drawIn(arena)
        }
        arena.onMouseDown { me ->
            monster = monster.touch( Point(me.x,me.y) )
        }
    }
    onFinish { }
}