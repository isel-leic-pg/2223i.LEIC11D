
fun main() {
	val a = (0..9).random()
	val b = (0..9).random()
	print("$a + $b = ? ")
	val ans = readln().toInt()
	println(a + b == ans)
}