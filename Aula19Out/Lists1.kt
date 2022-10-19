fun main() {
  val l1: List<Char> = listOf('X','3','a','b')
  showList(l1)
  val l2 = ('a'..'z').toList()
  showList(l2)
  val l3 = l2 + 'Z' + '0'
  showList(l3)
  showList(listOf())
  val l4 = l1.filter{ c -> c in 'a'..'z' }
  showList(l4)
  val l5 = l2.map{ c -> c+1 }.filter{ c -> c<'e' }
  showList(l5)
}

fun showList(l: List<Char>) {
  println("List = $l (${l.size})")
  if (l.size>0)
	println("first=${l[0]} last=${l[l.size-1]}")
}