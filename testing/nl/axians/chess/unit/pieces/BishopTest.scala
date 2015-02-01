package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.Color.WHITE
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.BishopMove
import nl.axians.chess.game.Game

class BishopTest extends FlatSpec {

  "A bishop" should "be able to move diagonally" in {
    var b: Board = new DefaultBoard
    var g = new Game(b)
    
    // A pawn is in the way.
    assert(!new BishopMove(WHITE, g, Location('C', 1), Location('A', 3)).isValid)
    // Move the pawn far away to make room for the bishop.
    b = b.movePiece(Location('B', 2), Location('H', 3))
    g = new Game(b)
    // The move should now be valid
    assert(new BishopMove(WHITE, g, Location('C', 1), Location('A', 3)).isValid)
//    b = b.movePiece(Location('C', 1), Location('A', 3))
    // Straight lines are invalid.
//    assert(!new BishopMove(new Bishop(WHITE), Location('A', 3), Location('A', 4)).isValid(b))
  }
}