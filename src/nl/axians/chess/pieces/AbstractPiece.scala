package nl.axians.chess.pieces

import nl.axians.chess.Color._

abstract class AbstractPiece(val color: Color) {
  override def toString = getAlgebraicNotationName + (if(color == WHITE) "w" else "b")
  
  /**
   * Returns the official name of this piece in algebraic notation.
   */
  def getAlgebraicNotationName: Char
}
