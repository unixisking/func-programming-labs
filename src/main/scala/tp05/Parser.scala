package tp05

import scala.util.parsing.combinator.RegexParsers

/**
 * t --> '('t')'
 *    |  '\z'
 *    |  false
 *    |  true
 *    |  if t then t else t
 *    |  0
 *    |  succ t
 *    |  pred t
 *    |  iszero t
 */
class Parser extends RegexParsers {
  def term : Parser[Term] = parenTerm | cond | truthy | falsy | zero | succ | pred | iszero | eof
  def parenTerm = ("("~>term<~")")
  def truthy = "true" ^^ { _ => True }
  def falsy = "false" ^^ { _ => False }
  def zero = "0" ^^ { _ => Zero}
  def succ = "succ" ~> term ^^ { term => Succ(term)}
  def pred = "pred" ~> term ^^ { term => Pred(term)}
  def iszero = "iszero" ~> term ^^ {term => IsZero(term)}
  def cond = "if" ~ term ~ "then"  ~ term ~ "else" ~ term ^^ { case "if" ~ c ~ "then"  ~ first ~ "else" ~ second => Cond(c, first, second) }
  def eof = """\z""".r ^^ { _ => EOF }
}