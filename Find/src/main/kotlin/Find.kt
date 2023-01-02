
// val idx = indexOfInt(grades,20)

fun indexOfInt_A(lst: List<Int>, value: Int): Int {
    for (i in lst.indices)
        if (lst[i]==value)
            return i
    return -1
}

fun indexOfInt_B(lst: List<Int>, value: Int): Int {
    repeat(lst.size) { i ->
        if (lst[i] == value)
            return i
    }
    return -1
}

fun indexOfInt(lst: List<Int>, value: Int): Int =
    lst.indexOf(value)