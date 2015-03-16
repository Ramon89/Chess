package nl.axians.chess.ai.treesearch.pruning

import nl.axians.chess.Color
import nl.axians.chess.ai.treesearch.evaluation.EvaluationFunction
import nl.axians.chess.game.Board
import nl.axians.chess.ai.treesearch.Tree

/**
 * This minimax prune function will minimize the loss in worst case scenario's. Only the opponent's nodes are pruned
 * such that the best scenario's for the opponent remain.
 */
class MiniMax(color: Color, maxNodes: Int, evaluationFunctions: List[EvaluationFunction]) extends PruneFunction(color, evaluationFunctions) {
  
  override def apply(nodes: List[Tree]): List[Tree] = {
    if(nodes == Nil)
      Nil
//    else if(nodes(0).color == color) 
//      nodes
    else {
      val nodeEvaluationPairs = nodes.map(n => (EvaluationFunction.evaluate(n.root, n.color, evaluationFunctions), n))
      val bestNodeEvaluationPairs = nodeEvaluationPairs.filter(e1 => !nodeEvaluationPairs.exists(e2 => e2._1 > e1._1))
      val bestNodes = bestNodeEvaluationPairs.map(e => e._2)
      if(bestNodes.size > maxNodes)
        bestNodes.slice(0, maxNodes)
      else
        bestNodes
    } 
  }
}