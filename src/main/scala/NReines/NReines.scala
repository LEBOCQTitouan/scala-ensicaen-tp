package NReines

class NReines(val n: Int) {


  // Question 1 :
  // étant donnée la position des reines précedentes, renvoye vrai si la colone est compatible
  def estOk(col: Int, reines: List[Int], offset : Int = 1): Boolean = {
    if (reines.isEmpty)
      true
    else if (
      reines.head == col
      || areOnSameDiag(col, reines.head, offset)
    )
      false
    else estOk(col, reines.tail, offset + 1)
  }

  def areOnSameDiag(reine1: Int, reine2: Int, offsetReine : Int): Boolean = {
    (reine1 + offsetReine == reine2) || (reine1 - offsetReine == reine2)
  }

  // Question 2
  // calcule la liste des solutions
  lazy val solutions: Set[List[Int]] = getSolutionDepth()

  def getSolutionDepth(nDepth: Int = n) : Set[List[Int]] = {
    if (nDepth == 0)
      Set()
    else {
      val solutions = getSolutionDepth(nDepth - 1)
      if (solutions.isEmpty)
        (0 until n).map(List(_)).toSet
      else {
        solutions.flatMap(
          solution => {
            (0 until n).filter(
              col => estOk(col, solution)
            ).map(
              col => col :: solution
            )
          }
        )
      }
    }
  }

  // Question 3
  // Retourne le nombre de solutions
  lazy val nombreSolutions: Int = solutions.size

  // question 4
  // transforme une solution en un String afichable
  def afficheSolution(solution: List[Int]): String = {
    solution.map(
      value => {
        val line = (0 until n).map(
          col => if (col == value) "X" else "O"
        ).mkString(" ")
        line
      }
    ).mkString("\n")
  }

  def afficheToutesSolutions(): Unit = for {
    (solution, i) <- solutions.zipWithIndex
  } println(s"Solution N°${i + 1} :\n " + afficheSolution(solution))


}
