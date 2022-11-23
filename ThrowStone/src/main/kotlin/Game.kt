import pt.isel.canvas.Canvas

data class Dimension(val width: Int, val height: Int)

data class Game(
    val stone: Stone,
    val monsters: List<Monster>,
    val dim: Dimension
)

fun createGame(arena: Dimension) = Game(
    stone = Stone( center = Point(0,0) ),
    monsters = List(NUMBER_OF_MONSTERS) {
        createMonster(arena.width, arena.height)
    },
    dim = arena
)

fun Canvas.drawGame(g: Game) {
    erase()
    g.monsters.forEach { it.drawIn(this) }
    if (g.stone.time>0) drawStone(g.stone)
}

fun Game.throwStone(click: Point): Game = copy(
    stone = createStone(click.x, click.y),
    monsters = monsters.map { it.touch( click ) }
)

fun Game.update(time: Int): Game = copy(
    stone = stone.timePass(time),
    monsters = monsters.map { it.randomMove(dim.width, dim.height)}
)

fun Game.isOver(): Boolean = monsters.all { it.dead }