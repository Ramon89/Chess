package nl.axians.chess.unit

import org.scalatest.FlatSpec
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.Location
import nl.axians.chess.game.InvalidLocationException
import nl.axians.chess.game.InvalidMoveException
import nl.axians.chess.White
import nl.axians.chess.Black

class BoardTest extends FlatSpec {
  "A board" should "allow moving a piece" in {
    val b = new DefaultBoard
    b.movePiece(Location('A', 1), Location('A', 2))
  }
  
  it should "produce InvalidLocationException if either the 'from' or the 'to' location is not valid" in {
	val b = new DefaultBoard
    intercept[InvalidLocationException] {
      b.movePiece(Location('A', 1), Location('A', -1))
    }
    intercept[InvalidLocationException] {
      b.movePiece(Location('A', -1), Location('A', 1))
    }
  }
  
  it should "produce InvalidMoveException if there is no piece at the 'from' location" in {
	val b = new DefaultBoard
    intercept[InvalidMoveException] {
      b.movePiece(Location('A', 3), Location('A', 4))
    }
  }
  
  it should "return a list of locations that are occupied by a given color" in {
    val b = new DefaultBoard
    
    val locationsWhite = for {
      x <- 'A' to 'H'
      y <- 1 to 2
    } yield Location(x, y)
    
    val locationsBlack = for {
      x <- 'A' to 'H'
      y <- 7 to 8
    } yield Location(x, y)
    
    assert(b.getOccupiedLocations(White).toSet == locationsWhite.toSet)
    assert(b.getOccupiedLocations(Black).toSet == locationsBlack.toSet)
  }
  
  it should "return a list of locations that are not occupied by a given color" in {
    val b = new DefaultBoard
    
    val locationsNotWhite = for {
      x <- 'A' to 'H'
      y <- 3 to 8
    } yield Location(x, y)
    
    val locationsNotBlack = for {
      x <- 'A' to 'H'
      y <- 1 to 6
    } yield Location(x, y)
    
    assert(b.getUnoccupiedLocations(White).toSet == locationsNotWhite.toSet)
    assert(b.getUnoccupiedLocations(Black).toSet == locationsNotBlack.toSet)
  }
}