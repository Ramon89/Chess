package nl.axians.chess

abstract class AbstractPiece(val color: Color, val algebraicNotationName: Char) {
  override def toString = algebraicNotationName + (if(color == White) "w" else "b")
}

case class Pawn(c: Color) extends AbstractPiece(c, 'P')
case class Rook(c: Color) extends AbstractPiece(c, 'R')
case class Knight(c: Color) extends AbstractPiece(c, 'N')
case class Bishop(c: Color) extends AbstractPiece(c, 'B')
case class Queen(c: Color) extends AbstractPiece(c, 'Q')
case class King(c: Color) extends AbstractPiece(c, 'K')