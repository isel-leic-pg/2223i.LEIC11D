
/**
 * Read a line.
 * @param q question
 * @return Read line
*/
fun readString(q: String): String {
	print("$q ? ")
	return readln()
}

fun readInt(quest: String) = readString(quest).toInt()

fun readFloat(quest: String): Float = readString(quest).toFloat()
