fun main() {
	print("Numero ? ")
	val n = readln().toInt()
	val message = 
		if (n>0) "positivo" 
		else if (n==0) "zero" else "negativo"
	println("O número $n é $message")
}