package nl.axians.chess.ai.treesearch.evaluation

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

object EvaluationFunction {
  
  /**
   * Evaluates the given board for the given color using the given evaluation functions. The sum of all the given 
   * functions applied to the board, is returned.
   */
  def evaluate(board: Board, color: Color, evaluationFunctions: List[EvaluationFunction]): Int = {
    evaluationFunctions.map(function => function(board, color)).sum
  }
}