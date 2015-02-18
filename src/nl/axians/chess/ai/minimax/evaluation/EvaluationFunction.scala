package nl.axians.chess.ai.minimax.evaluation

import nl.axians.chess.game.Board
import nl.axians.chess.Color

/**
 * Classes that derive from this one are to be used to evaluate board situations for a particular player.
 */
abstract class EvaluationFunction {
  
  /**
   * Applies this evaluation function; returning a number that counts as a reward or penalty (negative number).
   */
  def apply(board: Board, player: Color): Int
}