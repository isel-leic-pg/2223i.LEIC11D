fun main() {
	print("Numero ? ")
	val n = readln().toInt()
	if (n == 0) {
		println("Zero")
		println("Positivo")
	}
	else
		if (n > 0) println("Positivo")
		else println("Negativo")
}