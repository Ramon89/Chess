package nl.axians.chess.pieces

import nl.axians.chess.Color._

case class Bishop(c: Color) extends AbstractPiece(c) {
  override def getAlgebraicNotationName = 'B'
}
