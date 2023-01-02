

fun <T,R> List<T>.myMap( transform: (T)->R ): List<R> {
    val res = mutableListOf<R>()
    for(e in this)
        res.add( transform(e) )
    return res
}

fun <T> List<T>.myFilter( condition: (T)->Boolean ): List<T> {
    val res = mutableListOf<T>()
    for (e in this)
        if ( condition(e) ) res.add(e)
    return res
}

fun <T> List<T>.myForEach( action: (T)->Unit ) {
    for (e in this)
        action(e)
}

fun main() {
    println( listOf(3,6,7,9,12,1).myMap{ 'A'+it } )
    println( listOf(3,6,null,9,12,1).myFilter{ it!=null && it%2==0 } )
    listOf(3,6,7,9,12,1).myForEach { print(it) }
    for( e in listOf(3,6,7,9,12,1))
        print(e)
}