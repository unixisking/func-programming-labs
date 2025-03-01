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
    case EOF => false
    case True => true
    case False => true
    case Zero => true
    case Cond(condition, truthy, falsy) => false
    case Succ(t) => isVal(t)
    case Pred(t) => false
    case IsZero(t) => false
  

  /** t est-il une valeur numérique ? */
  def isNumVal(t : Term) : Boolean = t match
    case EOF => false
    case True => false
    case False => false
    case Zero => true
    case Cond(condition, truthy, falsy) => false
    case Succ(t) => isNumVal(t)
    case Pred(t) => false
    case IsZero(t) => false
  
}