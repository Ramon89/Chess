package nl.axians.chess.movement

import nl.axians.chess.Color._
import nl.axians.chess.game.Board

class Resign(color: Color, b: Board) extends AbstractMove(color: Color) {
  
  /**
   * Resigning is always allowed.
   */
  override def validate = true
  
  override def execute = b // TODO what else? Tell the game instance that the game is over?
}