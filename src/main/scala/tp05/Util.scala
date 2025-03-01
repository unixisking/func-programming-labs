package tp05

/* 
Values: 
    True, False, Zero, Succ*(Zero)
 Numerical Values: 
    Zero, Succ*(Zero) 
 */
object Util {
  /** t est-il une valeur ? */
  def isVal(t : Term) : Boolean = t match
    case True => true
    case False => true
    case Zero => true
    case Succ(t) => isVal(t)
    case _ => false
  

  /** t est-il une valeur numérique ? */
  def isNumVal(t : Term) : Boolean = t match
    case Zero => true
    case Succ(t) => isNumVal(t)
    case _ => false
}