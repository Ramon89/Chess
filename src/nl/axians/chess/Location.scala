package nl.axians.chess

import Math.min
import Math.max
import Math.abs
import nl.axians.chess.game.Board
import scala.annotation.tailrec

/**
 * A Location represents a position on a board, e.g. A1 (which would be bottom-left).
 */
case class Location(val x: Char, val y: Int) {
  
  /**
   * Returns whether this instance is between the given two locations.
   */
  @tailrec
  final def isBetween(first: Location, second: Location): Boolean = {
    val deltaX = second.x - first.x
    val deltaY = second.y - first.y
    val absDeltaX = abs(deltaX)
    val absDeltaY = abs(deltaY)
    val singleStepX = if(deltaX == 0) 0 else deltaX / absDeltaX
    val singleStepY = if(deltaY == 0) 0 else deltaY / absDeltaY
    val steppedLocation = Location((first.x + singleStepX).toChar, first.y + singleStepY)
    
    if(first == second || this == first || this == second)
      false // There can be nothing between one and the same location.
    else if(absDeltaX != absDeltaY && min(absDeltaX, absDeltaY) != 0)  
      false // The two locations are not in a straight/diagonal line.
    else if(this == steppedLocation)
      true
    else
      isBetween(steppedLocation, second)
  }
}