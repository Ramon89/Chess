package nl.axians.chess

object Color extends Enumeration {
    type Color = Value
    val WHITE, BLACK = Value
    
    override def toString = if(Value == WHITE) "w" else "b"
}
