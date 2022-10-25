
fun printOk(number: Int) =
    println("Ok $number")

fun main() {
    repeat(5,::printOk)
    repeat(3) { print(it) }
    println("----")
    for (i in 3..6 step 2)
        println("For $i")
    val l = listOf("pg","isel","leic")
    for (s in l)  println(s)
    for (c in "abcdef") println(c)
    println("----")
    var resp = 'S'
    while( resp=='S') {
        print("Quer continuar (S/N) ? ")
        resp = readln().trim()[0].uppercaseChar()
    }
    while(true) {
        print("Quer continuar (S/N) ? ")
        val r = readln().trim()[0].uppercaseChar()
        if (r!='S') break
    }
}