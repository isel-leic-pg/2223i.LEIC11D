

fun fact(n: Int): Long = if(n==0) 1 else fact(n-1)*n

fun fact_I(n: Int): Long {
    var res = 1L
    var v = n
    while(v > 0) {
        res *= v
        v -= 1
    }
    return res
}

fun sum(a: Int, b: Int): Int = if (a>0) sum(a-1,b+1) else b

fun f(n: Int): String = if (n<=9) "$n" else "$n"+f(n/10)