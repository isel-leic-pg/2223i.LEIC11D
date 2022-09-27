
fun main() {
   print("Nome? ")
   val name = readln()
   println("Hello $name")
   
   print("2 + 3 = ? ")
   val res :Int = readln().toInt()
   val ok :Boolean = res==5
   println("2+3=$res is $ok")
}
