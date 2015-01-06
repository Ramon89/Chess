package nl.axians.chess.pieces

import nl.axians.chess.Color._

case class King(c: Color) extends AbstractPiece(c) {
  override def getAlgebraicNotationName = 'K'
}