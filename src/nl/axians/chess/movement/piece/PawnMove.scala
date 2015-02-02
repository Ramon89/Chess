package nl.axians.chess.movement.piece

import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.Color
import nl.axians.chess.movement.RegularMove
import nl.axians.chess.movement.SinglePiece
import nl.axians.chess.game.Game
import nl.axians.chess.White
import nl.axians.chess.Black
import nl.axians.chess.AbstractPiece
import nl.axians.chess.movement.SinglePieceWithStraightLine
import Math.abs

/**
 * The super class of all variations of pawn moves.
 */
abstract class PawnMove(c: Color, g: Game, from: Location, to: Location) extends RegularMove(c, g, from, to) with SinglePiece {
  protected val dirNormaliser = if(color == White) 1 else -1
  protected val absStepsY = abs(deltaY)
  
  /**
   * Determines whether the current direction is correct for a pawn of the given color.
   */
  protected def isRightDirection = (deltaY > 0 && color == White) || (deltaY < 0 && color == Black)
  
  /**
   * For all pawn moves, the direction must be right.
   */
  override def defaultValidations = (() => isRightDirection)::super.defaultValidations
}

/**
 * The most common pawn move where the pawn moves one single step forwards.
 */
class SingleStepPawnMove(c: Color, g: Game, from: Location, to: Location) extends PawnMove(c, g, from, to) {
  override def validate = board.isEmpty(to) && isVerticalLine && absStepsY == 1
  override def isAttack = false
}

/**
 * The pawn move where the pawn moves two steps forwards in a straight line.
 */
class DoubleStepPawnMove(c: Color, g: Game, from: Location, to: Location) extends PawnMove(c, g, from, to) 
with SinglePieceWithStraightLine {
  override def validate = 
    ((color == White && from.y == 2) || (color == Black && from.y == 7)) && 
    board.isEmpty(to) && isVerticalLine && absStepsY == 2
    
  override def isAttack = false
}

/**
 * The diagonal pawn move that is an attack.
 */
class PawnAttack(c: Color, g: Game, from: Location, to: Location) extends PawnMove(c, g, from, to) {
  override def validate = board.getPieceAt(to) match {
	case Some(piece) => isDiagonalLine && absStepsY == 1 && piece.color != color
	case None        => false
  }
  
  override def isAttack = true
}

/**
 * Any pawn move can be mixed with a promotion.
 */
trait Promotion[Piece <: AbstractPiece] extends PawnMove {
  override def execute = {
    super.execute
//    board.setPiece(Piece(color), to)
  }
}
 