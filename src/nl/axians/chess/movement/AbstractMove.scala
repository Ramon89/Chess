package nl.axians.chess.movement

import nl.axians.chess.Location
//import nl.axians.chess.movement.constraints.Constraint
import nl.axians.chess.game.Board
import nl.axians.chess.game.Game
import nl.axians.chess.game.InvalidMoveException
import nl.axians.chess.Color._


abstract class AbstractMove(protected val color: Color, protected val board: Board) {
  
  /**
   * Returns whether this move is valid and can be executed.
   */
  def isValid = defaultValidations.forall(function => function()) && validate
  
  /**
   * Executes this move and returns the board that is the result of this move.
   */
  def execute: Board
  
  /**
   * Returns whether this move is valid.
   */
  protected def validate: Boolean
  
  /**
   * Returns a list of functions that are to be called by default on validation.
   */
  protected def defaultValidations: List[() => Boolean] = Nil
}
