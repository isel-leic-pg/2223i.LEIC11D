import kotlin.io.path.*

fun <T> List<T>.allPairsFor( condition: (T,T) -> Boolean ): List<Pair<T,T>> {
    val res = mutableListOf<Pair<T,T>>()
    for(i in 0 until lastIndex) {
        val a = this[i]
        for(j in (i+1) .. lastIndex) {
            val b = this[j]
            if ( condition(a,b) ) res.add(a to b)
        }
    }
    return res
}

fun main() {
    val numbers = Path("Numbers.txt").readLines().map { it.toInt() }
    val pairs = numbers.allPairsFor{ a, b -> a + b == 2023 }
    pairs.forEach{  (a,b) ->
        println("$a + $b = 2023")
    }
    numbers.allPairsFor{ a,b -> a==b+1 || a+1==b }.forEach { println(it) }
    println( listOf('I','S','E','J','L').allPairsFor{ a, b -> a+1==b } )
}