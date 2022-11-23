import pt.isel.canvas.Canvas

private const val MONSTER_SIZE = 100
private const val DELTA_MOVE = 30

enum class MonsterType(val dead: String, val alive: String) {
    BLUE("splash-blue", "monster1"),
    ORANGE("splash-orange", "monster2"),
    GREEN("splash-green", "monster3")
}

data class Monster(
    val center: Point,
    val dead: Boolean=false,
    val type: MonsterType
)

fun createMonster(width: Int, height: Int) =
    Monster(
        Point(
            x = (0..width).random(),
            y = (0..height).random()
        ),
        type = MonsterType.values().random()
    )

fun Monster.drawIn(cv: Canvas) {
    val img = if (dead) type.dead else type.alive
    /*
    = when(type) {
        MonsterType.GREEN -> if (dead) "splash-green" else "monster3"
        MonsterType.ORANGE -> if (dead) "splash-orange" else "monster2"
        MonsterType.BLUE -> if (dead) "splash-blue" else "monster1"
    }
    */
    cv.drawImage(img,
        center.x-MONSTER_SIZE/2, center.y-MONSTER_SIZE/2,
        MONSTER_SIZE, MONSTER_SIZE
    )
}

fun Monster.randomMove(width: Int, height: Int): Monster {
    if (dead) return this
    val dx = (-DELTA_MOVE..DELTA_MOVE).random()
    val dy = (-DELTA_MOVE..DELTA_MOVE).random()
    val p = center.move(dx,dy)
    return if (p.inside(width,height)) copy( center=p ) else this
}

fun Monster.touch(p: Point): Monster =
    if (center.distanceTo(p) < MONSTER_SIZE/2) copy(dead=true)
    else this