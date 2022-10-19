fun main() {
  val key = listOf(35,3,15,21,29)
  val lucky = 11
  println("$key + $lucky")
  val sortedKey = key.sorted()
  println("$sortedKey + $lucky")
  //println(key.shuffled())
  val bet: List<Int> = readBet()
  println(bet)
}

fun readBet(): List<Int> {
  while( true ) {
	  print("Bet ? ")
	  val line = readln()
	  println(line)
	  val strings: List<String> = line.split(" ").filter{ it.length>0 }
	  println(strings)
	  if (strings.size==6)
		return strings.map{ s -> s.toInt() }
	  else
	    println("A aposta não tem 6 números")
  }
}