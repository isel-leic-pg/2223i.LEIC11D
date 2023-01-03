
fun main() {
    println(f(12345))

    val n = 17
    val f = fact(n)
    println("$n! = $f")

    val grades = randomInts(25,min=0,max=20)
    println(grades)
    val sortedGrades = grades.sorted()
    println(sortedGrades)
    val idx = indexOfSortedInt(sortedGrades,10)
    println("$idx")
    if (idx!=-1) println("-> ${sortedGrades[idx]}")

}