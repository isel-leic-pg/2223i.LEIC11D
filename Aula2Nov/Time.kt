data class Time(val hours: Int, val minutes: Int, val seconds: Int)

fun readTime(): Time {
    print("Introduza horas:minutos:segundos ")
    val listOfInts = readln().split(":").map{ it.toInt() }
    return Time(listOfInts[0], listOfInts[1], listOfInts[2])
}

fun Time.toInt(): Int = hours*3600+minutes*60+seconds

fun Time.sameHour(other:Time) = hours==other.hours

fun main( ){
   val t=readTime()
   println(t)
   val t1=Time(10,20,30)
   val t2=Time(10,20,20)
   println(t1.sameHour(t2))
}

