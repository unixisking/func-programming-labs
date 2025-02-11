package coursera

import org.scalatest._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit.Assert._


import coursera.LabOne._

@RunWith(classOf[JUnitRunner])
class LabOneTest extends AnyFunSuite {

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

    test("countChange: example given in instructions") {
    assertEquals(coinChange(4,List(1,2)), 3)
  }

  test("countChange: sorted CHF") {
    assertEquals(coinChange(300,List(5,10,20,50,100,200,500)), 1022)
  }

  test("countChange: no pennies") {
    assertEquals(coinChange(301,List(5,10,20,50,100,200,500)), 0)
  }

  test("countChange: unsorted CHF") {
    assertEquals(coinChange(300,List(500,5,50,100,20,200,10)), 1022)
  }
  
}
