package nl.axians.chess.unit

import org.scalatest.FlatSpec
import nl.axians.chess.Location
import nl.axians.chess.game.DefaultBoard

class LocationTest extends FlatSpec {
  "A Location" should "return the locations between it and another location" in {
    val b = new DefaultBoard
    val start1 = Location('A', 1)
    val start2 = Location('D', 1)
    val end1 = Location('C', 1)
    val end2 = Location('A', 3)
    val end3 = Location('C', 3)
    val end4 = Location('A', 8)
    val end5 = Location('A', 4)
    assert(b.getLocationsBetween(start1, end1) == List(Location('B', 1)))
    assert(b.getLocationsBetween(end1, start1) == List(Location('B', 1)))
    assert(b.getLocationsBetween(start1, end2) == List(Location('A', 2)))
    assert(b.getLocationsBetween(end2, start1) == List(Location('A', 2)))
    assert(b.getLocationsBetween(start1, end3) == List(Location('B', 2)))
    assert(b.getLocationsBetween(end3, start1) == List(Location('B', 2)))
    assert(b.getLocationsBetween(start1, end4).toSet == (for(y <- 2 to 7) yield Location('A', y)).toSet)
    assert(b.getLocationsBetween(end4, start1).toSet == (for(y <- 2 to 7) yield Location('A', y)).toSet)
    assert(b.getLocationsBetween(start2, end5) == List(Location('B', 3), Location('C', 2)))
  }
  
  it should "return an empty list if the two locations are identical" in {
    val b = new DefaultBoard
    val start = Location('A', 1)
    assert(b.getLocationsBetween(start, start) == Nil)
  }
  
  it should "return an empty list if the locations between cannot be determined" in {
    val b = new DefaultBoard
    val start = Location('A', 1)
    val end = Location('C', 2)
    assert(b.getLocationsBetween(start, end) == Nil)
  }
}