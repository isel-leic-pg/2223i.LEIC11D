import kotlin.io.path.*

fun main() {
    val lines = Path("Lusiadas.txt").readLines()
    lines.forEachIndexed { idx, line ->
        println("${idx+1}: $line")
    }
    println("Total: ${lines.sumOf { it.length }} symbols.")
    //Path("Result.txt").writeText("Test")
}