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
    val steps = deltaY * d
	// Pawns move vertically, but cannot attack that way.
    if(isVerticalLine) {
      // The 'to' location must be empty.
      if(board.isEmpty(to)) {
        steps match {
          // Single step is valid.
          case 1 => result = true
          // Double step is only valid if the pawn is at its initial location and the passing spot is empty.
          case 2 => result = board.isEmpty(Location(to.x, to.y + d)) && 
              (color == White && from.y == 2) || 
              (color == Black && from.y == 7)
          // All other steps are invalid.
          case _ => result = false
        }
      }
    } else if(isDiagonalLine) {
      // The only possibility left is the capture of a piece of the opponent.
      result = board.getPieceAt(to) match {
        case Some(piece) => steps == 1 && piece.color != color // The piece to attack must be the opponent's.
        case None        => false // If there is no piece, a diagonal move is invalid.
      }
    }
    
    result
  }
  
  /**
   * A Pawn move is an attack if it is diagonal.
   */
  override def isAttack = isDiagonalLine
}