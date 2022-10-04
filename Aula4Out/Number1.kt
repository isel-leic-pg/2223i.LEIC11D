fun main() {
	print("Numero ? ")
	val n = readln().toInt()
	if (n == 0) {
		println("Zero")
		println("Positivo")
	}
	if (n > 0) println("Positivo")
	if (n < 0) println("Negativo")
}