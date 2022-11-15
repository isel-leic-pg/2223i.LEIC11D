import pt.isel.canvas.Canvas

private const val MONSTER_SIZE = 100
private const val DELTA_MOVE = 30

data class Monster(val center: Point, val dead: Boolean=false)

fun createMonster(width: Int, height: Int) =
    Monster( Point(
        x = (0..width).random(),
        y = (0..height).random()
    ) )

fun Monster.drawIn(cv: Canvas) {
    val img = if (dead) "splash-blue" else "monster1"
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
    return if (p.inside(width,height)) Monster( p ) else this
}

fun Monster.touch(p: Point): Monster =
    if (center.distanceTo(p) < MONSTER_SIZE/2) copy(dead=true)
    else this