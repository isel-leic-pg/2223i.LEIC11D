
fun main() {
    var total = 0
    var n = 1
    var line: String?
    do {
        line = readlnOrNull()
        if (line!=null) {
            println("$n: $line")
            n++
            total += line.length
        }
    } while( line!=null )
    println("Total: $total symbols.")
}