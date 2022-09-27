fun main() {
  //val total = "45 603".toInt() // 45603
  println("Total em segundos?")
  val txt :String = readln()
  println("Linha = $txt")
  val total = txt.toInt()
  
  val h = total / (60*60)
  val m = total % (60*60) / 60
  val s = total % 60
  // println(h)
  // println(m)
  // println(s)
  println("$h:$m:$s = ${total}secs.")
  println(h*3600+m*60+s)
}