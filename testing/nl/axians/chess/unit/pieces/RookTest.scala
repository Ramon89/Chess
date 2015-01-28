package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec

import nl.axians.chess.Color.WHITE
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.RookMove

class RookTest extends FlatSpec {

  "A rook" should "be able to move a straight lines" in {
    var b: Board = new DefaultBoard
    
    // A pawn is in the way.
    assert(!new RookMove(WHITE, b, Location('A', 1), Location('A', 3)).isValid)
    // Move the pawn far away to make room for the rook.
    b = b.movePiece(Location('A', 2), Location('H', 3))
    // The move should now be valid
    assert(new RookMove(WHITE, b, Location('A', 1), Location('A', 3)).isValid)
    b = b.movePiece(Location('A', 1), Location('A', 3))
    // Non-straight lines are invalid.
    assert(!new RookMove(WHITE, b, Location('A', 3), Location('H', 4)).isValid)
  }
}