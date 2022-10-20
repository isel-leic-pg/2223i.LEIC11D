
fun main() {
  val l = (1..10).shuffled()
  println(l)
  println(l.indices)
  val idx = 3
  println(idx in l.indices)
  l.forEach{ n -> print("$n ") }
  println()
  l.forEachIndexed{ idx,n -> print("$idx:$n ")  }
  val l2 = l.filterIndexed{ i,n -> n%2==0 && i%2==0 }
  println(l2)
  val l3 = l.mapIndexed{ i,_ -> 'A'+i }
  println(l3)
}