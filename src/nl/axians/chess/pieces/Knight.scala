package nl.axians.chess.pieces

import nl.axians.chess.Color._

case class Knight(c: Color) extends AbstractPiece(c) {
  override def getAlgebraicNotationName = 'N'
}
