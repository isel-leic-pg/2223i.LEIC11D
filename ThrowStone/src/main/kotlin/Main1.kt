import pt.isel.canvas.*

private const val STONE_SIZE = 100

fun main() {
    onStart {
        val arena = Canvas(800,400,WHITE)
        arena.drawCircle(arena.width/2,arena.height/2,100,RED)
        arena.drawImage(
            "stone",
            arena.width/2-STONE_SIZE/2,
            arena.height/2-STONE_SIZE/2,
            STONE_SIZE,
            STONE_SIZE
        )
    }
    onFinish { }
}