package nl.axians.chess.ai.minimax.evaluation

import nl.axians.chess.game.Board
import nl.axians.chess.Color
import nl.axians.chess.Rook
import nl.axians.chess.Bishop
import nl.axians.chess.Pawn
import nl.axians.chess.Knight
import nl.axians.chess.Queen
import nl.axians.chess.King

/**
 * Sums the relatives values of all pieces of the player's color and subtract the sum of the opponent's.
 */
object CountPieces extends EvaluationFunction {

  override def apply(board: Board, player: Color) = {
    def negateIfNecessary(value: Int, color: Color) = if(color == player) value * 1 else value * -1
    
    // For all locations, sum the relative values of the pieces.
    board.getLocations.map(location => board.getPieceAt(location) match {
      case Some(Pawn(color))   => negateIfNecessary(10, color)
      case Some(Knight(color)) => negateIfNecessary(30, color)
      case Some(Bishop(color)) => negateIfNecessary(30, color)
      case Some(Rook(color))   => negateIfNecessary(50, color)
      case Some(Queen(color))  => negateIfNecessary(90, color)
      case Some(King(_))       => 0
      case None                => 0
    }).sum
  }

}