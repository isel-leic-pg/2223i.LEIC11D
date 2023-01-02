

// randomInts(25,min=0,max=20)
fun randomInts_A(dim: Int, min: Int, max: Int): List<Int> {
    val res = mutableListOf<Int>()
    for (i in 0 until dim) {
        res.add((min..max).random())
    }
    return res
}

fun randomInts_B(dim: Int, min: Int, max: Int): List<Int> {
    val res = mutableListOf<Int>()
    repeat(dim) {
        res.add((min..max).random())
    }
    return res
}

fun randomInts_B1(dim: Int, min: Int, max: Int) = buildList {
    repeat(dim) {
        add((min..max).random())
    }
}

fun randomInts_C(dim: Int, min: Int, max: Int): List<Int> =
    (0 until dim).map{ (min..max).random() }

fun randomInts(dim: Int, min: Int, max: Int) =
    List(dim){ (min..max).random() }