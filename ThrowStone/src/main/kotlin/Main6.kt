import pt.isel.canvas.*

/**
 * Shows many monsters moving randomly in the arena.
 * Each monster is crushed when a stone is thrown at it.
 * The game representation causes only one mutability point and reduces the complexity of the main function.
 */
fun main() {
    onStart {
        val arena = Canvas(width = 800, height = 400, background = WHITE)
        var game = createGame( Dimension(arena.width,arena.height) )
        arena.drawGame(game)
        arena.onMouseDown { me: MouseEvent ->
            game = game.throwStone( Point(me.x,me.y) )
            //if (game.isOver()) arena.onTime(2000) { arena.close() }
        }
        arena.onTimeProgress(UPDATE_TIME) {
            game = game.update(UPDATE_TIME)
            arena.drawGame(game)
        }
    }
    onFinish { }
}