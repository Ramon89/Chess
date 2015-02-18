package nl.axians.chess.ai.minimax

import nl.axians.chess.GameListener
import nl.axians.chess.game.Game
import nl.axians.chess.ai.AI
import nl.axians.chess.game.Board
import nl.axians.chess.Color
import nl.axians.chess.ai.minimax.evaluation.CountPieces

class Shannon1948(color: Color, game: Game) extends AI(color, game) {
  val evaluationFunctions = List(CountPieces)

  /**
   * Evaluates a board for a given color, using all the enlisted evaluation functions.
   */
  private def evaluate(board: Board, color: Color): Int = {
    evaluationFunctions.map(function => function(board, color)).sum
  }
  
  def turnChanged(currentTurn: Color) = {
    if(currentTurn == color) {
      val possibleMoves = game.getPossibleMoves(color)
      
      val bestMove = possibleMoves.find(m1 => possibleMoves.forall(m2 => evaluate(m2.execute, color) <= evaluate(m1.execute, color)))
      game.execute(bestMove.get)
    }
  }
  
  def check(checkedPlayer: Color) = { }
  def checkMate(winner: Color) = { }  
  def boardChanged(newBoard: Board) = { }
}