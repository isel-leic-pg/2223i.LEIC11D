import kotlin.math.sqrt

data class Dimension(val width: Int, val height: Int) // Dimensões da grelha
data class Cell(val col:Int, val line:Int)
enum class Dir(val dCol: Int, val dLine: Int) {
    LEFT(-1,0), RIGHT(+1,0), UP(0,-1), DOWN(0,+1)
}
operator fun Cell.plus(dir: Dir) = Cell(col + dir.dCol, line + dir.dLine)
data class PacMan(val cell: Cell, val dir: Dir)
data class Ghost(val cell: Cell, val dir: Dir)
data class Game(
    val dim: Dimension, val pacman: PacMan,
    val pellets: List<Cell>,
    val walls: List<Cell>,
    val ghosts: List<Ghost> = emptyList()
)

fun Ghost.distanceTo(pacman: PacMan): Double {
    val dc = cell.col - pacman.cell.col
    val dl = cell.line - pacman.cell.line
    return sqrt((dc*dc + dl*dl).toDouble())
}

fun Game.createRandomFreeCell(): Cell =
    ((0 until dim.height).flatMap { l ->
        (0 until dim.width).map { c -> Cell(c,l) }
    } - walls - pacman.cell).random()

fun addRandomGhosts(game: Game, numberOfGhosts: Int): List<Ghost> =
    List(numberOfGhosts) { Ghost(game.createRandomFreeCell(),Dir.LEFT) }

fun List<Ghost>.move(game: Game): List<Ghost> =
    map { g ->
        val c = g.cell + g.dir
        if (c in game.walls) g else g.copy(cell=c)
    }