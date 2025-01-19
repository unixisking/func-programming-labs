package complex

/**
 * Une classe modélisant les nombres complexes
 */
class Complex(val real: Double, val imag: Double):
  /**
   * Pour afficher élégamment les nombres complexes, y compris quand la partie
   * réelle est nulle ou quand la partie imaginaire vaut -1, 0 ou 1
   */
  override def toString = {
    (real, imag) match {
      case (0, 0) => "0"
      case (0, 1) => "i"
      case (0, -1) => "-i"
      case (x, 0) if x > 0 => s"${real}"
      case (0, y) if y > 0 => s"${imag}i"
      case (x, 1) if x > 0 => s"${real} + i"
      case (x, -1) if x > 0 => s"${real} - i"
      case (x, y)  if x > 0 && y > 0 => s"${real} + ${imag}i"
      case (x, y) if x > 0 && y < 0 => s"${real} - ${imag*(-1)}i"
      case (x, y) if x < 0 && y < 0 => s"${real} - ${imag*(-1)}i"
      case _ => ""
    }
  }

  override def equals(obj: Any): Boolean = obj match
    case that: Complex => that.real == this.real && that.imag == this.imag
    case _ => false


  override def hashCode(): Int = (real, imag).hashCode()
    
  /**
   * Le module du nombre complexe
   * rappel : module(a + bi) = sqrt(a * a + b * b)
   */
  def mod = {
    Math.sqrt(real * real + imag * imag)
  }
  /**
   * L'argument d'un nombre complexe
   * rappel : argument(c = a + bi) = acos(a / module(c))
   */
  def arg = {
    Math.acos(real / mod)
  }
  /**
   * Le complexe obtenu en additionnant "this" et "that"
   */
  def +(that: Complex) = {
    Complex(real+real, imag+imag)
  }
  /**
   * Le complexe obtenu en additionnant "this" et "that"
   */
  def +(that: Double) = {
    Complex(real + that, imag)
  }
  /**
   * Le complexe obtenu en soustrayant "that" à "this"
   */
  def -(that: Complex) = {
    Complex(real - that.real, imag - that.imag)
  }
  /**
   * Le complexe obtenu en soustrayant "that" à "this"
   */
  def -(that: Double) = {
    Complex(real - that, imag)
  }
  /**
   * Le complexe obtenu en multipliant "this" et "that"
   */
  def *(that: Complex) = {
    Complex(
      (that.real * real) - (that.imag * imag),
      (real * that.imag) + (that.real * imag)
    )
  }
  /**
   * Le complexe obtenu en multipliant "this" et "that"
   */
  def *(that: Double) = {
    Complex(real*that, imag*that)
  }
  /**
   * Le complexe obtenu en divisant "this" par "that"
   */
  def /(that: Complex) = {
    Complex(real*that.real, imag*that.imag)
  }
  /**
   * Le complexe obtenu en divisant "this" par "that"
   */
  def /(that: Double) = {
    Complex(real*that, imag)
  }
  /**
   * Le complexe conjugué de "this"
   * rappel : conj(a + bi) = a - bi
   */
  def conj = {
    Complex(real, imag*(-1))
  }

  def >(that: Complex) = {
    real > that.real && imag > that.imag
  }

  def <(that: Complex) = {
    real < that.real && imag > that.imag
  }
end Complex

extension (x: Int)
  def +(that: Complex) = Complex(that.real + x, that.imag)
