
fun op(name: String, op: Char, fx: (Int,Int)->Int) {
  println("$name:")
  val a = readInt("A")
  val b = readInt("B")
  val res = fx(a,b)
  println("$a $op $b = $res")
}

fun plus(x: Int, y:Int): Int  = x + y
fun minus(q: Int, w:Int)  = q - w
fun mult(x: Int, y:Int)  = x * y
fun div(x: Int, y:Int)  = x / y

fun main() {
	op("Soma",'+',::plus)
	op("Subtração",'-',::minus)
	op("Mutiplicação",'x',::mult)
	op("Divisão",'/',::div)
}