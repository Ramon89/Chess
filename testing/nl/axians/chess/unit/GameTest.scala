package nl.axians.chess.unit

import org.scalatest.FlatSpec
import nl.axians.chess.game.Game
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.White
import nl.axians.chess.Location
import nl.axians.chess.Black

class GameTest extends FlatSpec {
  "A game" should "determine whether locations are safe" in {
    val g = new Game(new DefaultBoard)
    
    val safeLocations = g.getBoard.getLocations.filter(l => g.isSafe(l, White))
    var actualSafeLocations = (for {
      x <- 'A' to 'H'
      y <- 1 to 5
    } yield Location(x, y)).toList
    
    actualSafeLocations = Location('A', 8)::actualSafeLocations
    actualSafeLocations = Location('H', 8)::actualSafeLocations
    
    assert(safeLocations.toSet == actualSafeLocations.toSet)
  }
  
  it should "return the location of the king of each color" in {
    val g = new Game(new DefaultBoard)
    
    assert(g.getKingsLocation(White) == Location('E', 1))
    assert(g.getKingsLocation(Black) == Location('E', 8))
  }
  
  // TODO create test for check
  // TODO create test for possible moves
}