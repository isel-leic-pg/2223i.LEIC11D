
fun readLines(): List<String> {
    val lines = mutableListOf<String>()
    while (true)
        lines.add(readlnOrNull() ?: break)
    return lines
}

fun main() {
    val lines = readLines()
    lines.forEachIndexed { idx, line ->
        println("${idx+1}: $line")
    }
    println("Total: ${lines.sumOf { it.length }} symbols.")
}