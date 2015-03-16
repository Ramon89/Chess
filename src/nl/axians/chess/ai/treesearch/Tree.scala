package nl.axians.chess.ai.treesearch

import nl.axians.chess.Color
import nl.axians.chess.game.Board
import nl.axians.chess.game.Game
import nl.axians.chess.ai.treesearch.evaluation.EvaluationFunction
import nl.axians.chess.ai.treesearch.pruning.PruneFunction
import nl.axians.chess.movement.Move
import scala.collection.mutable.MutableList

case class Tree private[treesearch](val move: Move, val color: Color, val plies: Int, val pruneFunction: Option[PruneFunction], val treeBuilder: TreeBuilder) {
  
  val root = move.execute
  
  val leaves: List[Tree] = 
      if(plies < 0)
        throw new IllegalArgumentException("Number of plies must be larger than 0")
      else if(plies == 0) {
        treeBuilder.leaves += this
        Nil
      } else {
        val possibleMoves = new Game(root).getPossibleMoves(color)
        if(possibleMoves == Nil) {
          treeBuilder.leaves += this
          Nil
        } else {
          pruneFunction match {
            case Some(f) => f(possibleMoves.map(m => Tree(m, color.opponent, plies - 1, pruneFunction, treeBuilder)))
            case None    => possibleMoves.map(m => Tree(m, color.opponent, plies - 1, pruneFunction, treeBuilder))
          }
        }
      }
    
  def getLeaves = leaves
  
  def size: Int = {
    var sum = 1
    leaves.foreach(l => sum += l.size)
    sum
  }
}

class TreeBuilder {
  private[treesearch] var leaves: MutableList[Tree] = MutableList()
  
  def build(game: Game, plies: Int, pruneFunction: Option[PruneFunction]) = {
    val possibleMoves = game.getPossibleMoves(game.getCurrentTurn)
    possibleMoves.map(m => Tree(m, m.color, plies, pruneFunction, this))
  }
}
