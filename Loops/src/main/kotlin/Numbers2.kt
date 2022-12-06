import kotlin.io.path.*

fun main() {
    val numbers = Path("Numbers.txt").readLines().map { it.toInt() }
    val pairs = mutableListOf<Pair<Int,Int>>()
    numbers.forEach{ a ->
        val b = numbers.firstOrNull { a+it == 2023 }
        if (b != null && (b to a) !in pairs)
            pairs.add(a to b)
    }
    pairs.forEach{  (a,b) ->
        println("$a + $b = 2023")
    }
}