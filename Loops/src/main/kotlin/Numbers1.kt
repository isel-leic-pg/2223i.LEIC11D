import kotlin.io.path.*

fun List<Int>.indexOfMax(): Int {
    if (isEmpty()) return -1
    var idx = 0
    for(i in 1..lastIndex)
        if (this[i] > this[idx])
            idx = i
    return idx
}

fun main() {
    println( listOf(3,7,5).indexOfMax() )
    println( listOf<Int>().indexOfMax() )

    val numbers = Path("Numbers.txt").readLines().map { it.toInt() }
    val idx = numbers.indexOfMax()
    println("Max= [$idx] -> ${numbers[idx]}")
}