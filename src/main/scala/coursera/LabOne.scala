package coursera

object LabOne:
    def balance(chars: List[Char]): Boolean = {
        @annotation.tailrec
        def rec(chars: List[Char], stack: List[Char]): Boolean = chars match {
            case Nil => stack.length == 0  // If all characters are processed, stack should be empty
            case '(' :: rest => rec(rest, stack :+ '(') // Push to stack
            case ')' :: rest => 
                if (stack.length == 0) false // If stack is empty and ')' appears, unbalanced
                else rec(rest, stack.dropRight(1)) // Pop from stack
            case _ :: rest => rec(rest, stack) // Ignore non-parenthesis characters
        }
        rec(chars, List())
  }
    def coinChange(money: Int, coins: List[Int]): Int = {
        if (money == 0) 1  // Base case: one way to make 0 money
        else if (money < 0 || coins.isEmpty) 0  // No way to make change
        else {
            val include = coinChange(money - coins.head, coins) // Use the first coin
            val exclude = coinChange(money, coins.tail) // Skip the first coin
            include + exclude  // Sum the ways
        }
  }

end LabOne
