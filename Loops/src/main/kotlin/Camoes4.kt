
fun main() {
    var total = 0
    for(n in 1..10000) {
        val line = readlnOrNull() ?: break
        println("$n: $line")
        total += line.length
    }
    println("Total: $total symbols.")
}