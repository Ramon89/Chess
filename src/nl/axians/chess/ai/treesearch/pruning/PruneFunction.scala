package nl.axians.chess.ai.treesearch.pruning

import nl.axians.chess.Color
import nl.axians.chess.ai.treesearch.evaluation.EvaluationFunction
import nl.axians.chess.game.Board
import nl.axians.chess.ai.treesearch.Tree

abstract class PruneFunction(val color: Color, val evaluationFunctions: List[EvaluationFunction]) {
  def apply(nodes: List[Tree]): List[Tree]
}