 package tp01.pascal

/**
 * Une petite application permettant d'afficher les premières lignes du triangle
 *  de Pascal.
 * Deux méthodes sont proposées :
 * - l'une simple, mais gourmande en calculs, affiche les valeurs une par une au
 *  fil du calcul ;
 * - l'autre plus efficace en temps, mais plus technique et gourmande en mémoire,
 *  construit le triangle entièrement avant de l'afficher.
 */
object Pascal:
  def main(args: Array[String]): Unit =
    println("Le triangle de Pascal valeur par valeur :")
    // printTriangle1(args(0).toInt)
    printTriangle1(4)
    println("Le triangle de Pascal en un seul coup :")
    printTriangle2(4)


  /**
   * Renvoie la valeur de la case ("c", "r") du triangle de Pascal
   */
  def value(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else value(c - 1, r - 1) + value(c, r - 1)
  }

  /**
   * Affiche les "n" premières lignes du triangle de Pascal valeur par valeur
   * (à l'aide de la méthode "value")
   */
  def printTriangle1(n: Int): Unit = {
    (0 until n).map(r => {
      (0 to r).map(c => print(s"${value(c, r)} "))
      println()
    })
  }

  type Line = List[Int]

  /**
   * Renvoie la ligne suivant "line" dans le triangle de Pascal
   */
  private def nextLine(line: Line): Line = {
    val tmp = (0 :: line) :+ 0
    tmp.sliding(2).toList.map {
      case List(a, b) => a + b
      case List(a) => a
      case _ => 1
    }
  }

  /**
   * Renvoie les "n" premières lignes du triangle de Pascal
   */
   def triangle(n: Int): List[Line] = {
     if (n == 0) List(List(1))
     else {
       val tr = triangle(n - 1)
       tr :+ nextLine(tr.last)
     }
   }

  /**
   * Affiche les "n" premières lignes du triangle de Pascal ligne par ligne
   * (à l'aide de la méthode "triangle")
   */
  def printTriangle2(n: Int) = {
    val result = triangle(n - 1)
    for (line <- result) {
      for (num <- line) {
        print(s"${num} ")
      }
      println()
    }
  }
end Pascal