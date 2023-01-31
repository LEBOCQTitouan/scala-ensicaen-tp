package ASCIIart

class ASCIIart(art: String) {

  val (largeur, hauteur, liste) = {
    val f = art.split('\n')
    (f(0).toInt, f(1).toInt, f.drop(2).toList)
  }

  lazy val tableLettre: Map[Char, List[String]] = listeToMap()

  // question 1 : renvoie la Map qui associe chaque lettre à son ascii art
  // attention : si la lettre n'est pas définie, il fait renvoyer l'ascii-art du symbole ? fourni en derniere position
  private def listeToMap(): Map[Char, List[String]] = ???

  // question 2 : renvoie le mot sous forme d'ascii art
  def apply(mot: String): String = ???


}
