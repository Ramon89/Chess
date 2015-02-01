package nl.axians.chess.movement.piece

import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.Color
import nl.axians.chess.movement.RegularMove
import nl.axians.chess.movement.SinglePiece
import nl.axians.chess.game.Game
import nl.axians.chess.White
import nl.axians.chess.Black

class PawnMove(c: Color, g: Game, from: Location, to: Location) extends RegularMove(c, g, from, to) with SinglePiece {
  
  override def validate = {
    var result = false
    
    // This value is used to fix the direction, i.e. white moves forwards while black moves backwards.
    val d = if(c == White) 1 else -1
	// Pawns move vertically, but cannot attack that way.
    if(deltaX == 0) {
      // The 'to' location must be empty.
      if(board.isEmpty(to)) {
        val steps = deltaY * d
        steps match {
          // Single step is valid.
          case 1 => result = true
          // Double step is only valid if the pawn is at its initial location and the passing spot is empty.
          case 2 => result = board.isEmpty(Location(to.x, to.y + d)) && 
              (c == White && from.y == 2) || 
              (c == Black && from.y == 7)
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