

fun readOneLine(n: Int): String? {
    print("Linha $n? ")
    return readln().trim().ifEmpty { null }
}

fun readLines(max: Int): List<String> {
    var lines = emptyList<String>()
    repeat(max) {
        lines = lines + (readOneLine(it+1) ?: return lines)
    }
    return lines
}