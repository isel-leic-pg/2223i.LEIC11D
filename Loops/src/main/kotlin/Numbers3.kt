import kotlin.io.path.*

fun main() {
    val numbers = Path("Numbers.txt").readLines().map { it.toInt() }
    val pairs = mutableListOf<Pair<Int,Int>>()
    for (i in 0 until numbers.lastIndex) {
        val a = numbers[i]
        for(j in (i+1) .. numbers.lastIndex) {
            val b = numbers[j]
            if (a+b == 2023) pairs.add(a to b)
        }
    }
    pairs.forEach{  (a,b) ->
        println("$a + $b = 2023")
    }
}