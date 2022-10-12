
fun op(name: String, op: Char, fx: (Int,Int)->Int) {
  println("$name:")
  val a = readInt("A")
  val b = readInt("B")
  val res = fx(a,b)
  println("$a $op $b = $res")
}

fun main() {
	val plus = {x:Int, y:Int -> x+y }
	
	op("Soma",'+',plus)
	op("Subtração",'-', {w:Int,q:Int -> w-q} )
	op("Mutiplicação",'x', {a,b -> a*b } )
	op("Divisão",'/') {a,b ->
	   a/b
	}
}