package object Listes {

  // définir une méthode qui renvoie le dernier élément d'une liste s'il existe
  // s'il n'existe pas, on génére une exception NoSuchElementException
  @throws[NoSuchElementException]
  def dernier[T](liste: List[T]): T = {
    if (liste.isEmpty)
      throw new NoSuchElementException()
    if (liste.tail.isEmpty)
      return liste(0)
    dernier(liste.tail)
  }

  // définir une méthode qui renvoie le k-ieme élément d'une liste, en commençant par 0, s'il existe
  // s'il n'existe pas, on génére une exception IndexOutOfBoundsException
  @throws[IndexOutOfBoundsException]
  def kieme[T](liste: List[T], k: Int): T = {
    if (liste.isEmpty)
      throw new IndexOutOfBoundsException()
    if (k == 0)
      return liste(0)
    kieme(liste.tail, k-1)
  }

  // définir une méthode qui renvoie le nombre d'élément de la liste
  def taille[T](liste: List[T]): Int = {
    if (liste.isEmpty)
      return 0
    taille(liste.tail) + 1
  }

  // définir une méthode qui renvoie true si l'élément x est présent dans la liste
  def contient[T](liste: List[T], x: T): Boolean = {
    if (liste.isEmpty)
      return false
    if (liste(0) == x)
      return true
    contient(liste.tail, x)
  }

  // définir une méthode qui renvoie une nouvelle liste avec le k-ième élement supprimé
  // si k <= 0, on supprime le premier élément
  // si k>= taille, on renvoie la même liste
  def supprimerKieme[T](liste: List[T], k: Int): List[T] = {
    if (liste.isEmpty)
      return liste
    if (k <= 0)
      return liste.tail
    liste.head :: supprimerKieme(liste.tail, k-1)
  }

  // définir une méthode qui renvoie une nouvelle liste avec l'élément e en k-ième position
  // si k <= 0, on l'ajoute en premier élément
  // si k>= taille, on l'ajoute en dernier
  def ajouterKieme[T](liste: List[T], k: Int, e: T): List[T] = {
    if (liste.isEmpty || k <= 0)
      return e :: liste
    liste.head :: ajouterKieme(liste.tail, k-1, e)
  }

  // définir une méthode qui renvoie true si les deux listes sont identiques
  def identique[T](liste1: List[T], liste2: List[T]): Boolean = {
    if (liste1.isEmpty && liste2.isEmpty)
      return true
    if (liste1.isEmpty || liste2.isEmpty || liste1(0) != liste2(0))
      return false
    return identique(liste1.tail, liste2.tail)
  }

  // définir une méthode qui renvoie une nouvelle liste en ne gardant que les éléments qui renvoie true au prédicat
  def filtrer[T](liste: List[T], predicat: T => Boolean): List[T] = {
    if (liste.isEmpty)
      return liste
    if (predicat(liste(0)))
      return liste(0) :: filtrer(liste.tail, predicat)
    filtrer(liste.tail, predicat)
  }

  // définir une méthode qui renvoie une nouvelle liste où les éléments sont les résultats de f
  def image[T, U](liste: List[T], f: T => U): List[U] = {
    if (liste.isEmpty)
      return Nil
    f(liste(0)) :: image(liste.tail, f)
  }


}
