package nl.axians.chess

import Math.min
import Math.max
import Math.abs
import nl.axians.chess.game.Board

/**
 * A Location represents a position on a board, e.g. A1 (which would be bottom-left).
 */
case class Location(val x: Char, val y: Int) {
  
  def isBetween(first: Location, second: Location) = {
    def isBetween(i1: Int, i2: Int, i3: Int) =
      i1 > min(i2, i3) && i1 < max(i2, i3)
    val absDeltaX = abs(second.x - first.x)
    val absDeltaY = abs(second.y - first.y)
    
    if(absDeltaX != absDeltaY && absDeltaX != 0 && absDeltaY != 0)  
      false
    else if(absDeltaX == absDeltaY)
      isBetween(x, first.x, second.x) && isBetween(y, first.y, second.y)
    else if(absDeltaX == 0)
      x == first.x && isBetween(y, first.y, second.y)
    else
      y == first.y && isBetween(x, first.x, second.x)
  }
  
  // TODO move to board?
//  def getLocationsBetween(that: Location, b: Board): List[Location] = {
//    for {
//      l <- b.getLocations
//      if l isBetween (this, that)
//    } yield l
//  }
//  
//  def getLocationsBetween(that: Location, b: Board, lambda: Location => Boolean): List[Location] =
//    for{
//      l <- getLocationsBetween(that, b)
//      if lambda(l)
//    } yield l
//    
//  def getOccupiedLocationsBetween(that: Location, b: Board) = getLocationsBetween(that, b, l => !b.isEmpty(l))
}