package nl.axians.chess.movement

import nl.axians.chess.Color._
import nl.axians.chess.game.Board
import nl.axians.chess.game.Game

class Resign(color: Color, game: Game) extends AbstractMove(color, game) {
  
  /**
   * Resigning is always allowed.
   */
  override def validate = true
  
  override def execute = board // TODO what else? Tell the game instance that the game is over?
}