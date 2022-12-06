
fun main() {
    var total = 0
    var n = 1
    while(true) {
        val line = readlnOrNull() ?: break
        println("$n: $line")
        n++
        total += line.length
    }
    println("Total: $total symbols.")
}