package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.pieces.Pawn
import nl.axians.chess.game.Board
import nl.axians.chess.Color._

class PawnMove(c: Color, from: Location, to: Location) extends RegularMove(c, from, to) {
  
  override def validate(b: Board) = {
    var result = false
    
    // This value is used to fix the direction, i.e. white moves forwards while black moves backwards.
    val d = if(c == WHITE) 1 else -1
	// Pawns move vertically, but cannot attack that way.
    if(deltaX == 0) {
      // The 'to' location must be empty.
      if(b.isEmpty(to)) {
        val steps = deltaY * d
        steps match {
          // Single step is valid.
          case 1 => result = true
          // Double step is only valid if the pawn is at its initial location and the passing spot is empty.
          case 2 => result = b.isEmpty(Location(to.x, to.y + d)) && 
              (c == WHITE && from.y == 2) || 
              (c == BLACK && from.y == 7)
          // All other steps are invalid.
          case _ => result = false
        }
      }
    } else {
      // The only possibility is the capture of a piece of the opponent.
      result = false // TODO implement this
    }
    
    result
  }
  
//  override def doApply(b: Board) = 0 // TODO do the magic! Which in this case is to simply move the piece
}