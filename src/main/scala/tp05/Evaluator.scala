package tp05

import Util._

class Evaluator {
  /** Réalise un pas d'évaluation, i.e. produit t' tel que t --> t'. */
  private def eval(t : Term) : Term = t match
    case Succ(t) if isNumVal(t) => Succ(t)
    case Succ(t) => t match
      case Zero => Succ(Zero)
      case Succ(t) => Succ(Succ(t))
      case Pred(subT) => subT match
        case Zero => Succ(Zero)
        case _ => throw new Exception("Can not evaluate Pred on this term")
      
      case IsZero(t) => Zero
      case _ => throw new Exception("Can not evaluate Succ on this term")
    case Pred(t) => t match
      case Zero => Zero
      case Pred(t) => t match
        case Zero => Zero
        case Pred(t) => eval(Pred(t))
      
      case Succ(t) => t match
        case Zero => Zero
        case Succ(t) => eval(Succ(t))
        // case => 

      case Cond(condition, truthy, falsy) => condition match
        case True => Pred(truthy)
        case False => Pred(falsy)
        case c => Pred(eval(c))
      

    case IsZero(t) => t match
      case Zero => True
      case Cond(condition, truthy, falsy) => condition match
        case True => IsZero(truthy)
        case False => IsZero(falsy)
        
      
      // Evaluating to raise exceptions even though we know it should be False.
      case Succ(t) => eval(Succ(t)) match
        case _ => False
      case Pred(t) => eval(Pred(t)) match
        case _ => False
      
      case _ => throw new Exception("Can not evaluate this on this term")
    
    case Cond(c, truthy, falsy) => c match
      case True => truthy
      case False => falsy
      case IsZero(t) => eval(IsZero(t)) match
        case True => truthy
        case False => falsy
        case _ => throw new Exception("Can not evaluate that on this term")
      
      case _ => throw new Exception("Can not evaluate Cond on this term")

    case _ => throw new Exception("blocked terms can not be evaluated")

    
  
  
  
  
  /** Evalue t jusqu'à obtenir un terme bloqué. */
  def evaluate(t : Term) : Term = {
    if (isVal(t)) t else evaluate(eval(t))
  }
}
