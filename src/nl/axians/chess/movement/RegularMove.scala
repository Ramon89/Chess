package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.movement.constraints.LocationsAreValid
import nl.axians.chess.Color._

/**
 * This abstract class corresponds to a regular chess move, i.e. the movement of one piece to another location.
 */
abstract class RegularMove(c: Color, from: Location, to: Location) extends AbstractMove(List(LocationTransition(from, to))) 
with LocationsAreValid {
  
  /**
   * The delta on the x axis for this move.
   */
  protected val deltaX = to.x - from.x
  
  /**
   * The delta on the y axis for this move.
   */
  protected val deltaY = to.y - from.y
  
// TODO: add default constraint that no piece can be in between the positions
  // TODO add default constraint that the locations cannot be identical
}