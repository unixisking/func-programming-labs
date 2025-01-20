package complex

class PolarComplex(val mod: Double, val angle: Double):
    lazy val cartesian = Complex(
        mod * Math.cos(angle), mod * Math.sin(angle)
    ) 
    override def equals(obj: Any): Boolean = cartesian.equals(obj)
    override def toString(): String = cartesian.toString

 
end PolarComplex