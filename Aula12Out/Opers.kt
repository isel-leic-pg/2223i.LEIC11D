
fun op(name: String, op: Char, fx: (Int,Int)->Int) {
  println("$name:")
  val a = readInt("A")
  val b = readInt("B")
  val res = fx(a,b)
  println("$a $op $b = $res")
}

fun main() {
	op("Soma",'+') {x,y->x+y}
	op("Subtração",'-') {w,q-> w-q}
	op("Mutiplicação",'x') {a,b -> a*b }
	op("Divisão",'/') {a,b ->
	   println("Div:")
	   a/b
	}
	op("Resto",'%') {a,b -> a % b}
}