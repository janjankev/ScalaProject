import java.io._

object Project {
  def main(args:Array[String]): Unit = {
    val pw = new PrintWriter(new File("result.txt"))
    val current = scala.io.Source.fromFile("file.txt").getLines().toList
      .flatMap(_.split(" ")).filter(x => x.matches("[a-zA-Z]+") && x.length > 1).foldLeft(Map.empty[String, Int]) {
      (count, word) => count + (word.toLowerCase() -> (count.getOrElse(word.toLowerCase(), 0) + 1))
    }
        current.toSeq.sortBy(_._1).foreach{
          case (key, value) => val output = key + " = " + value
            pw.println(output)
        }
    pw.close()
  }
}


