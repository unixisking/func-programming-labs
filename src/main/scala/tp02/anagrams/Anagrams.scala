package tp02.anagrams

import tp01.multiSet.MultiSet

/**
 * Un objet fournissant des outils pour construire des anagrammes de mots
 *  et de phrases.
 */
object Anagrams {
  /**
   * Un mot est une String.
   * Pour simplifier, on supposera qu'un mot ne contient que des caractères
   *  alphabétiques ou des tirets.
   * Il n'y aura aucun caractère accentué ou porteur d'un tréma ou d'une cédille.
   */
  type Word = String
  type Sentence = List[Word]

  /** 
   * Une "Occurrences" est une liste ordonnée de couples (Char, Int) (selon
   *  l'ordre alphabétique, un caractère apparaissant au plus une fois dans la
   *  liste).
   * Elle permet d'associer à un mot ou une phrase, la liste de ses
   *  caractères avec leur fréquence dans le mot ou dans la phrase.

   * Remarque : si la fréquence d'un caractère est nulle alors il n'apparait
   *  pas dans la liste.
   */
  type Occurrences = List[(Char, Int)]

  private val dictionary: List[Word] = {
    val resourceFile = new java.io.File("src/main/scala/tp02/resources/dico.txt")
    val source = io.Source.fromFile(resourceFile)
    source.getLines.toList
  }

  /** 
   * Convertit un mot en la liste des fréquences de ses caractères.
   * Les éventuelles majuscules seront assimilées aux caractères minuscules
   *  correspondants.
   */
  def wordOccurrences(w: Word): Occurrences = {
    val initialSet = MultiSet[Char](Map())
    val filledSet = w.toList.foldLeft(initialSet) {
      (acc, char) => acc.add(char.toLower, 1)
    }
    filledSet.elems.toList.sorted
  }
  /** 
   * Convertit une phrase en la liste des fréquences de ses caractères.
   */
  def sentenceOccurrences(s: Sentence): Occurrences = {
    val initialSet = MultiSet[Char](Map())
    val filledSet = s.foldLeft(initialSet) {
      (acc, word) => {
        val tmp = wordOccurrences(word)
        acc.union(MultiSet(tmp.toMap))
      }
    }
    filledSet.elems.toList.sorted
  }

  /** 
   * Une association qui fait correspondre à une liste de
   *  fréquences de caractères, les mots du dictionnaires
   *  compatibles avec cette liste.
   * Par exemple, les occurrences de caractères du mot "tri" sont :
   *  List(('i', 1), ('r', 1), ('t', 1))
   * Ce sont les mêmes occurrences pour les mots "tir" et "rit".
   * On aura donc l'entrée suivante dans l'association
   *  "dictionaryByOccurrences" :
   *  List(('i', 1), ('r', 1), ('t', 1)) -> List("rit", "tir", "tri")
   * Cela revient à regrouper les mots du dictionnaire anagrammes les
   *  uns des autres.
   */
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = {
    val initial = Map[Occurrences, List[Word]]()

    dictionary.foldLeft(initial) {
      (acc, word) => {
        val word_occ = wordOccurrences(word)
        acc.updatedWith(word_occ) {
          case Some(value) => Some(value :+ word)
          case None => Some(List(word))
        }
      }
    }
  }

  /**
   * Renvoie la liste des anagrammes de "word".
   */
  def wordAnagrams(word: Word): List[Word] = {
    val word_occ = wordOccurrences(word)
    dictionaryByOccurrences.get(word_occ).getOrElse(List())
  }
  /**
   * Retourne la liste de tous les "sous-ensembles" d'une liste de fréquences.
   * Par exemple : les sous-ensembles de la liste List(('a', 2), ('b', 2)) sont :
   *    List(
   *      List(),
   *      List(('a', 1)),
   *      List(('a', 2)),
   *      List(('b', 1)),
   *      List(('a', 1), ('b', 1)),
   *      List(('a', 2), ('b', 1)),
   *      List(('b', 2)),
   *      List(('a', 1), ('b', 2)),
   *      List(('a', 2), ('b', 2))
   *    )
   */
  // type Occurrences = List[(Char, Int)]
  def combinations(occurrences: Occurrences): List[Occurrences] = {

    def processTuple(result: Occurrences, char: Char, count: Int): Occurrences = {
      if (count == 0) result
      else processTuple(result :+ (char, count), char, count - 1) // Append and recurse
    }

    // for yield appel
    val result = for occ <- occurrences 
      sub_result = processTuple(List(), occ._1, occ._2)
      yield sub_result

    println(f"hello ${result}")
    List()
  }

  /**
   * Renvoie la liste de fréquences obtenue en retirant "y" à "x".
   */
  def subtract(x: Occurrences, y: Occurrences): Occurrences = ???

  /**
   * Renvoie la liste de toutes les phrases anagrammes de "sentence".
   * Par exemple, pour le paramètre List("a", "plus"), la méthode renvoie :
   *    List(
   *      List("su", "pal")
   *      List("us", "pal")
   *      List("pu", "las")
   *      List("lu", "pas")
   *      List("plus", "a")
   *      List("a", "plus")
   *      List("pas", "lu")
   *      List("las", "pu")
   *      List("pal", "su")
   *      List("pal", "us")
   *    )
   */
  def sentenceAnagrams(sentence: Sentence): List[Sentence] = ???
}