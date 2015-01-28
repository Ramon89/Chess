package nl.axians.chess.movement.piece

import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.Color._
import Math.abs
import Math.max
import Math.min
import nl.axians.chess.movement.RegularMove
import nl.axians.chess.movement.SinglePiece

class KnightMove(c: Color, b: Board, from: Location, to: Location) extends RegularMove(c, b, from, to) with SinglePiece {
  
  override def validate = {    
    val absDeltaX = abs(deltaX)
    val absDeltaY = abs(deltaY)    
    max(absDeltaX, absDeltaY) == 2 && min(absDeltaX, absDeltaY) == 1
  }
}