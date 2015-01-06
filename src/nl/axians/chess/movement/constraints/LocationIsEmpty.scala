package nl.axians.chess.movement.constraints

import nl.axians.chess.game.Board
import nl.axians.chess.movement.AbstractMove

trait LocationIsEmpty extends Constraint {
  
  /**
   * If all the target locations of a move are empty on the current board, return true.
   */
  override def apply(b: Board, m: AbstractMove) = m.locationTransitions.forall(lt => b.getPieceAt(lt.to) == None)
}