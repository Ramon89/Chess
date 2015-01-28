package nl.axians.chess.movement

import nl.axians.chess.Location
//import nl.axians.chess.movement.constraints.Constraint
import nl.axians.chess.game.Board
import nl.axians.chess.game.Game
import nl.axians.chess.game.InvalidMoveException
import nl.axians.chess.Color._


abstract class AbstractMove(protected val color: Color, protected val board: Board) {
  
  def isValid = defaultValidations.forall(function => function()) && validate
  
  /**
   * Returns whether this move is valid.
   */
  protected def validate: Boolean
  
  /**
   * Returns a list of functions that are to be called by default on validation.
   */
  protected def defaultValidations: List[() => Boolean] = List(() => moveDoesNotCauseChess)

  /**
   * Returns true if the current move does not cause chess.
   */
  private def moveDoesNotCauseChess = true // TODO
}
