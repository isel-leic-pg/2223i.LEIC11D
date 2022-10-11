
private val PI = 3.14159

fun circleArea(radius: Float) = PI * radius * radius

fun main() {
	val r: Float = readFloat("Raio")
	val area = circleArea(r)
	println("Area = $area")
}