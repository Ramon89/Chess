package nl.axians.chess.pieces

import nl.axians.chess.Color._

case class Pawn(c: Color) extends AbstractPiece(c) {
  override def getAlgebraicNotationName = 'P'
}
