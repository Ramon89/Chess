package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.game.Game
import nl.axians.chess.game.InvalidMoveException
import nl.axians.chess.Color

abstract class Move(protected val color: Color, protected val game: Game) {

  protected val board = game.getBoard
  
  /**
   * Returns whether this move is valid and can be executed.
   */
  def isValid = defaultValidations.forall(function => function()) && validate
  
  /**
   * Returns a list of functions that are to be called by default on validation.
   */
  protected def defaultValidations: List[() => Boolean] = Nil
  
  /************************************************** ABSTRACT METHODS **************************************************/
  
  /**
   * Executes this move and returns the board that is the result of this move.
   */
  def execute: Board
  
  /**
   * Returns whether this move can be an attack.
   */
  def isAttack: Boolean
  
  /**
   * Returns whether this move is valid.
   */
  protected def validate: Boolean
}
