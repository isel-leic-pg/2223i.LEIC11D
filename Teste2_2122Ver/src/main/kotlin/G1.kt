

fun readOneLine(n: Int): String? {
    print("Linha $n? ")
    return readln().trim().ifEmpty { null }
}

fun readLines(max: Int): List<String> = buildList {
    repeat(max) {
        add( readOneLine(it+1) ?: return@buildList )
    }
}

fun lengthAverageOf(lines: List<String>) =
    lines.sumOf { it.length }.toFloat() / lines.size

fun String.numberOfWords() =
    if (isEmpty()) 0 else count{ it==' ' }+1

fun List<String>.printIf(condition: (String)->Boolean) =
    filter(condition).forEach(::println)

fun main() {
    println("Introduza até 10 linhas de texto.")
    val lines = readLines(10)
    val avg = lengthAverageOf(lines)
    println("Média de símbolos por linha = $avg")
    println("==Linhas com mais do que $avg símbolos==")
    lines.printIf { it.length > avg }
    println("==Linhas com mais do que 2 palavras==")
    lines.printIf { it.numberOfWords() > 2 }
}

