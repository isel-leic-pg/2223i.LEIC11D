
fun op(name: String, op: Char) {
  println("$name:")
  val a = readInt("A")
  val b = readInt("B")
  val res = when(op) {
	'+' -> a + b
	'-' -> a - b
	'x' -> a * b
	else -> 0 // Smell code
  }
  println("$a $op $b = $res")
}

fun main() {
	op("Soma",'+')
	op("Subtração",'-')
	op("Mutiplicação",'x')
	op("Divisão",'/')
}