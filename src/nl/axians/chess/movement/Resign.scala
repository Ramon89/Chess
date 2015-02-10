package nl.axians.chess.movement

import nl.axians.chess.Color
import nl.axians.chess.game.Board
import nl.axians.chess.game.Game

class Resign(color: Color, game: Game) extends Move(color, game) {
  
  /**
   * Resigning is always allowed.
   */
  override def validate = true
  
  override def isAttack = false
  
  override def execute = game.getBoard // TODO what else? Tell the game instance that the game is over?
}