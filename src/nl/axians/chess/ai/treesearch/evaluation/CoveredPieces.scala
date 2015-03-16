package nl.axians.chess.ai.treesearch.evaluation

import nl.axians.chess.game.Board
import nl.axians.chess.Color
import nl.axians.chess.Rook
import nl.axians.chess.Bishop
import nl.axians.chess.Pawn
import nl.axians.chess.Knight
import nl.axians.chess.Queen
import nl.axians.chess.King
import nl.axians.chess.Knight

/**
 * Contains all evaluations that involve knights.
 */
object CoveredPieces extends EvaluationFunction {
  override def apply(board: Board, player: Color) = {
    0
  }
}