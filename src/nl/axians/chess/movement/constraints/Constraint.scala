package nl.axians.chess.movement.constraints

import nl.axians.chess.game.Board
import nl.axians.chess.movement.AbstractMove

trait Constraint extends AbstractMove {
  
  // Add this constraint to the list of constraints of the move.
  constraints = this::constraints
  
  /**
   * A constraint applies to a move on a board. It returns true if it is met for the given board and move.
   */
  def apply(board: Board, move: AbstractMove): Boolean

}