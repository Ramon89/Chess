package nl.axians.chess.movement

import nl.axians.chess.Location

/**
 * A LocationTransition is a data class storing the 'from' and the 'to' locations.
 */
case class LocationTransition(val from: Location, val to: Location)