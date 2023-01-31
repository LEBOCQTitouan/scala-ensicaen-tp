package object Parentheses {

  // Écrire une fonction récursive qui indique si une phrase dispose de parenthèses bien construite
  def equilibre(phrase: String): Boolean = ???

  // pareil, mais générique
  def equilibreGenerique(co: Char, cf: Char)(phrase: String): Boolean = ???

  // utiliser la fonction générique pour définir la version xml avec < et > comme caractère ouvrant/fermant
  lazy val equilibreXml: String => Boolean = ???

}
