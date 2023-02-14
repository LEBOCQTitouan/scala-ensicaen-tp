import scala.annotation.tailrec
import scala.collection.mutable

package object Parentheses {

  // Écrire une fonction récursive qui indique si une phrase dispose de parenthèses bien construite
  def equilibre(phrase: String): Boolean = {
    equilibreGenerique('(', ')')(phrase)
  }

  // pareil, mais générique
  def equilibreGenerique(co: Char, cf: Char)(phrase: String): Boolean = {
    if (phrase.equals("")) // TODO insert initial check for empty str in generique array
      return true
    equilibreGeneriqueArray(co, cf)(phrase.toCharArray)
  }

  @tailrec
  def equilibreGeneriqueArray(co: Char, cf: Char)(charArray: Array[Char], startCo: Char = co, didFindOpening : Boolean = false): Boolean = {
    if (charArray.length == 0) {
      didFindOpening && startCo == co
    } else if (charArray.head == co) {
      equilibreGeneriqueArray(cf, co)(charArray.tail, startCo, didFindOpening = true)
    } else
      equilibreGeneriqueArray(co, cf)(charArray.tail, startCo, didFindOpening)
  }

  // utiliser la fonction générique pour définir la version xml avec < et > comme caractère ouvrant/fermant
  lazy val equilibreXml: String => Boolean = (xml: String) => equilibreGeneriqueArray('<','>')(xml.toCharArray) // TODO not ok xml
}
