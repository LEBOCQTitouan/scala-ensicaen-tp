// les packages object permettent de définir des méthodes/variables disponibles dans tout le package
package object EnsemblesFonctions {

  // type est l'équivalent de typedef en C
  // On représente des ensembles à l'aide de fonctions Int => Boolean
  type Ensemble = Int => Boolean

  // indique si un ensemble contient un élément
  def contient(s: Ensemble, elem: Int): Boolean = s(elem)

  // limite est utilisé pour l'affichage, ainsi que les fonctions pourTout et ilExiste
  val limite = 100

  // Renvoie un ensemble sous forme de chaîne de caractères
  // compris entre -limite et +limite
  def chaine(s: Ensemble): String = {
    val xs = for (i <- -limite to limite if contient(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  // affiche un ensemble
  def afficheEnsemble(s: Ensemble): Unit = println(chaine(s))

  // définir l'ensemble des éléments positifs
  lazy val ensemblePositif: Ensemble = x => x >= 0

  // définit l'ensemble [10; 20]
  lazy val ensemble10a20: Ensemble = x => 10 <= x  && x <= 20

  // définir une méthode qui renvoie un singleton : l'ensemble qui ne contient que elem
  // i.e. la fonction qui renvoie vrai si on lui passe elem en paramètre, et faux sinon
  def singleton(elem: Int): Ensemble = {
    (test : Int) => test == elem
  }

  // définir une méthode qui renvoie l'union de deux ensembles
  def union(s: Ensemble, t: Ensemble): Ensemble = {
    (test : Int) => t(test) || s(test)
  }

  // définir une méthode renvoyant l'intersection de deux ensembles
  def intersection(s: Ensemble, t: Ensemble): Ensemble = {
    (test : Int) => s(test) && t(test)
  }

  // définir une méthode diff qui renvoie la différence de deux ensembles (dans s, pas dans t)
  def difference(s: Ensemble, t: Ensemble): Ensemble = {
    (test : Int) => s(test) && !t(test)
  }

  // définir une méhtode complement qui revoie le complément d'un ensemble
  def complement(s: Ensemble): Ensemble = {
    (test : Int) => !s(test)
  }

  //définir une méthode filtre, qui renvoie le sous ensemble pour lequel p est vraie
  def filtrer(s: Ensemble, p: Int => Boolean): Ensemble = {
    (test : Int) => s(test) && p(test)
  }

  // définir une méthode pourTout, qui vérifie si p est vrai pour tout élément de s (de -limite à +limite)
  def pourTout(s: Ensemble, p: Int => Boolean): Boolean = {
    testLimit(s, p, -limite)
  }

  def testLimit(s: Ensemble, p: Int => Boolean, i : Int): Boolean = {
    if (i > limite)
      return true
    if (!p(i) && s(i))
      return false
    testLimit(s, p, i+1)
  }

  // définir une méthode ilExiste qui renvoie vrai si un élément renvoie vraie pour p
  def ilExiste(s: Ensemble, p: Int => Boolean): Boolean = {
    testIlExist(s, p, -limite)
  }

  def testIlExist(s: Ensemble, p: Int => Boolean, i: Int): Boolean = {
    if (i > limite)
      return false
    if (s(i) && p(i))
      return true
    testIlExist(s, p, i+1)
  }

  // définir une fonction image qui renvoie l'ensemble image de s
  def image(s: Ensemble, f: Int => Int): Ensemble = {
    (test: Int) => imageRec(s, f, test, -limite)
  }

  def imageRec(s: Ensemble, f: Int => Int, n: Int, i: Int): Boolean = {
    if (i > limite)
      return false
    if (s(i) && n == f(i))
      return true
    imageRec(s, f, n, i+1);
  }
}
