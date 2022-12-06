
fun main() {
    var total = 0
    repeat(40) {
        val line: String? = readlnOrNull()
        if (line==null) {
            println("Total: $total symbols.")
            return
        }
        println("${it + 1}: $line")
        total += line.length
    }
    println("Total: $total symbols.")
}