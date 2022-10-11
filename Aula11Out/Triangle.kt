
fun main() {
	val a = readInt("Lado A")
	val b = readInt("Lado B")
	val c = readInt("Lado C")
	val type: String = when {
		a>=b+c || b>=a+c || c>=a+b -> "Impossível"
		a==b && b==c -> "Equilatero"
		a==b || b==c || a==c -> "Isósceles"
		else -> "Escaleno"
	}
	println("O triângulo ($a,$b,$c) é $type")
}
