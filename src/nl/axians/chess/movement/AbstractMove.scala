package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.movement.constraints.Constraint
import nl.axians.chess.game.Board
import nl.axians.chess.game.Game
import nl.axians.chess.game.InvalidMoveException

// TODO a move should apply to a players color.
abstract class AbstractMove(val locationTransitions: List[LocationTransition]) {
  // This is a list of constraints which determine if a move is valid or not.
  protected var constraints = List[Constraint]()
  
  /**
   * Checks if a move is valid on the given board. A move is valid if all constraints are met.
   */
  def isValid(b: Board): Boolean = constraints.forall(constraint => constraint.apply(b, this))
  
  // TODO instead of isValid that returns true/false, create method that returns which constraint makes this move invalid.
  
  /**
   * Executes this move if it is valid, otherwise an InvalidMoveException is thrown.
   */
  // TODO: not the board should be given, but the game instance. the current board can be asked from the game.
  def apply(b: Board) = if(isValid(b)) doApply(b) else throw new InvalidMoveException("This move is not valid") // TODO use I18N
    
  /**
   * This method actually performs the move.
   */
  protected def doApply(b: Board)
}
