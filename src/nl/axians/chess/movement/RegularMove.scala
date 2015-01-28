package nl.axians.chess.movement

import nl.axians.chess.Location
//import nl.axians.chess.movement.constraints.LocationsAreValid
import nl.axians.chess.Color._
import nl.axians.chess.game.Board
import Math.abs
import Math.max

/**
 * This abstract class corresponds to a regular chess move where one or more pieces move to a different location.
 */
abstract class RegularMove(color: Color, board: Board, protected val locationTransitions: List[LocationTransition]) 
extends AbstractMove(color, board) {
  
  def this(color: Color, board: Board, from: Location, to: Location) =
    this(color, board, List(LocationTransition(from, to)))
  
  /**
   * Returns true when all locations are valid.
   */
  private def locationsAreValid = 
    locationTransitions.forall(lt => board.isValidLocation(lt.from) && board.isValidLocation(lt.to))
  
  /**
   * Returns true when all locations are not occupied by pieces of the same color.
   */
  private def targetLocationsAreUnoccupied = 
    locationTransitions.forall(lt => board.getPieceAt(lt.to) match {
        case None        => true // If no piece is on a location, all it well.
        case Some(piece) => piece.color != color // All is well only if there is an opponents piece on a location.
    })

  /**
   * Returns true if the current move does not cause chess.
   */
  private def moveDoesNotCauseChess = true // TODO use execute to get the resulting board
  
  /**
   * A regular move is executed by applying all location transitions (i.e. moving all pieces).
   */
  override def execute = locationTransitions.foldLeft(board)((b, lt) => b.movePiece(lt.from, lt.to))
  
  /**
   * For all regular moves, all locations must be valid and the target locations must not be occupied by the same 
   * color.
   */
  override def defaultValidations = (() => locationsAreValid)::(() => targetLocationsAreUnoccupied)::
      (() => moveDoesNotCauseChess)::super.defaultValidations
}

/**
 * This trait contains common calculations for moves that involve one single location transition, i.e. moves that
 * involve a single piece to change its location.
 */
trait SinglePiece extends RegularMove {
  /**
   * The delta on the x axis for this move.
   */
  protected val deltaX = locationTransitions(0).to.x - locationTransitions(0).from.x
  
  /**
   * The delta on the y axis for this move.
   */
  protected val deltaY = locationTransitions(0).to.y - locationTransitions(0).from.y
  
  /**
   * Is the move horizontal?
   */
  protected val isHorizontalLine = deltaY == 0 && deltaX != 0
  
  /**
   * Is the move vertical?
   */
  protected val isVerticalLine = deltaX == 0 && deltaY != 0
  
  /**
   * Is the move diagonal?
   */
  protected val isDiagonalLine = abs(deltaX) == abs(deltaY)
  
  /**
   * A move is a straight line, if it is horizontal, vertical or diagonal. Otherwise, the move may not be valid.
   */
  protected val isStraightLine = isHorizontalLine || isVerticalLine || isDiagonalLine
}

/**
 * This trait contains functionality for moves with a single piece that should move in a straight line.
 */
trait SinglePieceWithStraightLine extends SinglePiece {
  /**
   * The number of steps that are taken. E.g. a bishop moving to a diagonally adjacent location performs one step. 
   */
  protected val steps = max(abs(deltaX), abs(deltaY))
  
  /**
   * Are there any obstacles (i.e. pieces of any color) on the straight line?
   */
  protected val noObstacles =
    board.getOccupiedLocationsBetween(locationTransitions(0).from, locationTransitions(0).to) == Nil
  
  /**
   * For all moves with a single piece with a straight line, there can be no obstacles on the path.
   */
  override def defaultValidations = (() => noObstacles)::super.defaultValidations
}