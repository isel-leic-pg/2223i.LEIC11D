
fun main() {
    val grades = randomInts(25,min=0,max=20)
    println(grades)
    val sortedGrades = grades.sorted()
    println(sortedGrades)
    val idx = indexOfInt(sortedGrades,10)
    println("$idx")
}