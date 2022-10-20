
const val KEY_SIZE = 5
const val BET_SIZE = KEY_SIZE + 1
val NUMBERS_RANGE = 1..49
val LUCKY_RANGE = 1..14

fun main() {
  val key = NUMBERS_RANGE.shuffled().take(KEY_SIZE) // = listOf(35,3,15,21,29)
  val lucky = LUCKY_RANGE.random()  // = 11
  println("${key.sorted()} + $lucky")
  val bet: List<Int> = readBet()  
  val betKey = bet.take(KEY_SIZE)
  val betLucky = bet.last()
  val keyHits = betKey.count{ it in key }
  val luckyHit = if (betLucky == lucky) 1 else 0
  println("Acertos: $keyHits + $luckyHit")
  showPremium(keyHits,luckyHit)
}

val names = listOf(
	"5 Números + Nº da Sorte",
	"5 Números", "4 Números",
	"3 Números", "2 Números",
	"Nº da Sorte",
)

fun showPremium(kh: Int, lh: Int) {
	val numPremium = when(kh) {
		5 -> if (lh==1) 1 else 2 // 2-lh
		4 -> 3
		3 -> 4
		2 -> 5
		0 -> if (lh==1) 6 else 0 // 6*lh
		else -> 0
	}
	if (numPremium>0) {
		val name = names[numPremium-1]
		println("Parabéns, acertou no $numPremium prémio ($name)")
	}
	else 
		println("Azar, jogue outra vez")
}

fun validBet(bet: List<Int>): Boolean {
   if (bet.size!=BET_SIZE) 
      return false   
   val key = bet.dropLast(1).distinct()
   val lucky = bet.last()
   return key.size==KEY_SIZE 
      && lucky in LUCKY_RANGE 
	  && key.all{ it in NUMBERS_RANGE }
}

fun readBet(): List<Int> {
  while( true ) {
	  print("Bet ? ")
	  val bet = readln()
	    .split(" ")
		.filter{ it.length>0 }
		.map{ s -> s.toInt() }
	  if (validBet(bet)) return bet
	  else println("A aposta não é válida")
  }
}