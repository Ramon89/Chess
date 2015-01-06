package nl.axians.chess.pieces

import nl.axians.chess.Color._

case class Queen(c: Color) extends AbstractPiece(c) {
  override def getAlgebraicNotationName = 'Q'
}
