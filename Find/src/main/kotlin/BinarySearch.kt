
fun indexOfSortedInt_I(l: List<Int>, value: Int): Int {
    val lst = l.toTypedArray()
    var min = 0
    var max = lst.lastIndex
    while(max >= min) {
        val mid = (min+max)/2
        if (lst[mid]==value)
            return mid
        if (value < lst[mid])
            max = mid-1
        else
            min = mid+1
    }
    return -1
}

fun indexOfSortedInt_R(l: List<Int>, value: Int, min: Int, max: Int): Int {
    val mid = (min+max)/2
    return when {
        min > max -> -1
        value == l[mid] -> mid
        value < l[mid] -> indexOfSortedInt_R(l,value,min,mid-1)
        else -> indexOfSortedInt_R(l,value,mid+1,max)
    }
}

fun indexOfSortedInt(l: List<Int>, value: Int): Int {
    fun find(min: Int, max: Int): Int {
        val mid = (min+max)/2
        return when {
            min > max -> -1
            value == l[mid] -> mid
            value < l[mid] -> find(min,mid-1)
            else -> find(mid+1,max)
        }
    }
    return find(0,l.lastIndex)
}













