package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.movement.constraints.LocationsAreValid

/**
 * This abstract class corresponds to a regular chess move, i.e. the movement of one piece to another location.
 */
abstract class RegularMove(from: Location, to: Location) extends AbstractMove(List(LocationTransition(from, to))) 
with LocationsAreValid {
// TODO: add default constraint that no piece can be in between the positions
}