package nl.axians.chess.pieces

import nl.axians.chess.Color._

case class Rook(c: Color) extends AbstractPiece(c) {
  override def getAlgebraicNotationName = 'R'
}
