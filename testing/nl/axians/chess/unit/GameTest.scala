package nl.axians.chess.unit

import org.scalatest.FlatSpec
import nl.axians.chess.Bishop
import nl.axians.chess.Black
import nl.axians.chess.Location
import nl.axians.chess.White
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.game.Game
import nl.axians.chess.movement.piece.PawnMove
import nl.axians.chess.movement.MoveFactory
import nl.axians.chess.game.InvalidMoveException

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
    actualSafeLocations = Location('E', 8)::actualSafeLocations
    
    assert(safeLocations.toSet.diff(actualSafeLocations.toSet) == Nil.toSet)
  }
  
  it should "return the location of the king of each color" in {
    val g = new Game(new DefaultBoard)
    
    assert(g.getKingsLocation(White) == Location('E', 1))
    assert(g.getKingsLocation(Black) == Location('E', 8))
  }
  
  it should "tell whether a player is in check" in {
    var g = new Game(new DefaultBoard)
    
    // Initially, neither black nor white is in check.
    assert(!g.isInCheck(White))
    assert(!g.isInCheck(Black))
    
    g = new Game(new DefaultBoard().setPiece(Bishop(White), Location('D', 7)))
    assert(g.isInCheck(Black))
  }
  
  it should "keep track of who's turn it is" in {
    val g = new Game(new DefaultBoard)
    val blackPawnMove = MoveFactory.get(g, Location('E', 7), Location('E', 5))
    val whitePawnMove = MoveFactory.get(g, Location('E', 2), Location('E', 4))
    val whiteQueenMove = MoveFactory.get(g, Location('D', 1), Location('H', 5))
    // It is not yet black's turn.
    intercept[InvalidMoveException] {
	  g.execute(Black, blackPawnMove);
    }
    
    // This should cause no trouble.
    g.execute(White, whitePawnMove)
    
    // Now black can move his pawn.
    g.execute(Black, blackPawnMove);
    
    // White's turn again.
    g.execute(White, whiteQueenMove)
  }
  
//  it should "tell whether a player is in check mate" in {
//    var b1 = new DefaultBoard().setPiece(Bishop(White), Location('D', 7))
//    var b2 = new DefaultBoard().setPiece(Bishop(White), Location('F', 7)).setPiece(Knight(White), Location('G', 7))
//    
//    
//    assert(!new Game(b1).isInCheckMate(Black))
//    assert(new Game(b2).isInCheckMate(Black))
//  }
  
  // TODO create test for check
  // TODO create test for possible moves
}