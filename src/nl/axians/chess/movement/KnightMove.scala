package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.pieces.Pawn
import nl.axians.chess.game.Board
import nl.axians.chess.Color._
import nl.axians.chess.pieces.Knight

class KnightMove(c: Color, from: Location, to: Location) extends RegularMove(c, from, to) {
  
  override def validate(b: Board) = {    
    val absDeltaX = Math.abs(deltaX)
    val absDeltaY = Math.abs(deltaY)
    val validMove = (absDeltaX == 1 && absDeltaY == 2) || (absDeltaX == 2 && absDeltaY == 1)
    b.getPieceAt(to) match {
      case None        => validMove
      case Some(piece) => piece.color != c && validMove
    }
  }
    
//  override def doApply(b: Board) = 0 // TODO do the magic! Which in this case is to simply move the piece
}