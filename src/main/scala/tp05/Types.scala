package tp05

// Grammar of the language
sealed trait Term
case object EOF extends Term
case object True extends Term
case object False extends Term
case object Zero extends Term
case class If(condition: Term, truthy: Term, falsy: Term) extends Term
case class Succ(t: Term) extends Term
case class Pred(t: Term) extends Term
case class isZero(t: Term) extends Term
