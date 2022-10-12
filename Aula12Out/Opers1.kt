fun opPlus() {
  println("Soma:")
  val a = readInt("A")
  val b = readInt("B")
  val res = a + b
  println("$a + $b = $res")
}

fun opMinus() {
  println("Subtração:")
  val a = readInt("A")
  val b = readInt("B")
  val res = a - b
  println("$a - $b = $res")
}

fun main() {
	opPlus()
	opMinus()
}