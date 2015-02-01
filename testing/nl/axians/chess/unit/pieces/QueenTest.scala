package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec

import nl.axians.chess.Location
import nl.axians.chess.White
import nl.axians.chess.game.Board
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.game.Game
import nl.axians.chess.movement.piece.QueenMove

class QueenTest extends FlatSpec {

  "The queen" should "be able to move diagonally" in {
    var b: Board = new DefaultBoard
    var g = new Game(b)
    
    // A pawn is in the way.
    assert(!new QueenMove(White, g, Location('D', 1), Location('A', 4)).isValid)
    // Move the pawn far away to make room for the queen.
    b = b.movePiece(Location('C', 2), Location('H', 3))
    g = new Game(b)
    // The move should now be valid
    assert(new QueenMove(White, g, Location('D', 1), Location('A', 4)).isValid)
  }
  
  it should "be able to move in straight lines as well" in {
    var b: Board = new DefaultBoard
    
    // Move the queen to another location.
    b = b.movePiece(Location('D', 1), Location('A', 4))
    val g = new Game(b)
    assert(new QueenMove(White, g, Location('A', 4), Location('E', 4)).isValid)
  }
}