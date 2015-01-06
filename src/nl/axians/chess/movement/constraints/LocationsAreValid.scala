package nl.axians.chess.movement.constraints

import nl.axians.chess.movement.AbstractMove
import nl.axians.chess.game.Board

/**
 * This constraint checks whether all locations that are involved in this move, are valid locations with respect to the
 * given board.
 */
trait LocationsAreValid extends Constraint {

  /**
   * The 'from' and 'to' locations of all LocationTransitions of this move are checked if they are valid.
   */
  override def apply(b: Board, m: AbstractMove) = m.locationTransitions
      .forall(lt => b.isValidLocation(lt.from) && b.isValidLocation(lt.to))
}