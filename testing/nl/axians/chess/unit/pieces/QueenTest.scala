package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.PawnMove
import nl.axians.chess.Color._
import nl.axians.chess.Location
import nl.axians.chess.movement.piece.KnightMove
import nl.axians.chess.movement.piece.RookMove
import nl.axians.chess.game.Board
import nl.axians.chess.movement.piece.QueenMove
import nl.axians.chess.game.Game

class QueenTest extends FlatSpec {

  "The queen" should "be able to move diagonally" in {
    var b: Board = new DefaultBoard
    val g = new Game
    
    // A pawn is in the way.
    assert(!new QueenMove(WHITE, b, g, Location('D', 1), Location('A', 4)).isValid)
    // Move the pawn far away to make room for the queen.
    b = b.movePiece(Location('C', 2), Location('H', 3))
    // The move should now be valid
    assert(new QueenMove(WHITE, b, g, Location('D', 1), Location('A', 4)).isValid)
  }
  
  it should "be able to move in straight lines as well" in {
    var b: Board = new DefaultBoard
    val g = new Game
    
    // Move the queen to another location.
    b = b.movePiece(Location('D', 1), Location('A', 4))
    assert(new QueenMove(WHITE, b, g, Location('A', 4), Location('E', 4)).isValid)
  }
}