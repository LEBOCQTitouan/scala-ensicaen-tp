package object Listes {

  // définir une méthode qui renvoie le dernier élément d'une liste s'il existe
  // s'il n'existe pas, on génére une exception NoSuchElementException
  @throws[NoSuchElementException]
  def dernier[T](liste: List[T]): T = ???

  // définir une méthode qui renvoie le k-ieme élément d'une liste, en commençant par 0, s'il existe
  // s'il n'existe pas, on génére une exception IndexOutOfBoundsException
  @throws[IndexOutOfBoundsException]
  def kieme[T](liste: List[T], k: Int): T = ???

  // définir une méthode qui renvoie le nombre d'élément de la liste
  def taille[T](liste: List[T]): Int = ???

  // définir une méthode qui renvoie true si l'élément x est présent dans la liste
  def contient[T](liste: List[T], x: T): Boolean = ???

  // définir une méthode qui renvoie une nouvelle liste avec le k-ième élement supprimé
  // si k <= 0, on supprime le premier élément
  // si k>= taille, on renvoie la même liste
  def supprimerKieme[T](liste: List[T], k: Int): List[T] = ???

  // définir une méthode qui renvoie une nouvelle liste avec l'élément e en k-ième position
  // si k <= 0, on l'ajoute en premier élément
  // si k>= taille, on l'ajoute en dernier
  def ajouterKieme[T](liste: List[T], k: Int, e: T): List[T] = ???

  // définir une méthode qui renvoie true si les deux listes sont identiques
  def identique[T](liste1: List[T], liste2: List[T]): Boolean = ???

  // définir une méthode qui renvoie une nouvelle liste en ne gardant que les éléments qui renvoie true au prédicat
  def filtrer[T](liste: List[T], predicat: T => Boolean): List[T] = ???

  // définir une méthode qui renvoie une nouvelle liste où les éléments sont les résultats de f
  def image[T, U](liste: List[T], f: T => U): List[U] = ???


}
