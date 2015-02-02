package nl.axians.chess.movement

import nl.axians.chess.game.Board
import nl.axians.chess.Color
import nl.axians.chess.Location
import nl.axians.chess.Pawn
import nl.axians.chess.Knight
import nl.axians.chess.King
import nl.axians.chess.Bishop
import nl.axians.chess.Queen
import nl.axians.chess.Rook
import nl.axians.chess.movement.piece.PawnMove
import nl.axians.chess.game.Game
import nl.axians.chess.movement.piece.BishopMove
import nl.axians.chess.movement.piece.KingMove
import nl.axians.chess.movement.piece.RookMove
import nl.axians.chess.movement.piece.KnightMove
import nl.axians.chess.movement.piece.QueenMove
import Math.abs
import nl.axians.chess.movement.piece.DoubleStepPawnMove
import nl.axians.chess.movement.piece.PawnAttack
import nl.axians.chess.movement.piece.SingleStepPawnMove

object MoveFactory {
  def get(game: Game, color: Color, locationTransitions: List[LocationTransition]): Option[Move] = {
    null
  }
  
  def get(game: Game, color: Color, from: Location, to: Location) = {
    game.getBoard.getPieceAt(from) match {

      case Some(p: Rook)   => new RookMove(color, game, from, to)
      case Some(p: Knight) => new KnightMove(color, game, from, to)
      case Some(p: Bishop) => new BishopMove(color, game, from, to)
      case Some(p: Queen)  => new QueenMove(color, game, from, to)
      case Some(p: King)   => new KingMove(color, game, from, to)
      case Some(p: Pawn)   => 
        if(abs(from.y - to.y) == 2) 
          new DoubleStepPawnMove(color, game, from, to)
        else if(from.x != to.x) 
          new PawnAttack(color, game, from, to)
        else 
          new SingleStepPawnMove(color, game, from, to)
      case Some(x)         => null // Throw an exception; this should never happen
      case None            => null
    }
  }
}