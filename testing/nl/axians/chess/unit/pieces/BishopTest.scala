package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.PawnMove
import nl.axians.chess.pieces.Pawn
import nl.axians.chess.Color._
import nl.axians.chess.Location
import nl.axians.chess.movement.KnightMove
import nl.axians.chess.pieces.Knight
import nl.axians.chess.movement.RookMove
import nl.axians.chess.pieces.Rook
import nl.axians.chess.game.Board
import nl.axians.chess.movement.BishopMove
import nl.axians.chess.pieces.Bishop

class BishopTest extends FlatSpec {

  "A bishop" should "be able to move diagonally" in {
    var b: Board = new DefaultBoard
    
    // A pawn is in the way.
    assert(!new BishopMove(new Bishop(WHITE), Location('C', 1), Location('A', 3)).isValid(b))
    // Move the pawn far away to make room for the bishop.
    b = b.movePiece(Location('B', 2), Location('H', 3))
    // The move should now be valid
    assert(new BishopMove(new Bishop(WHITE), Location('C', 1), Location('A', 3)).isValid(b))
    b = b.movePiece(Location('C', 1), Location('A', 3))
    // Straight lines are invalid.
//    assert(!new BishopMove(new Bishop(WHITE), Location('A', 3), Location('A', 4)).isValid(b))
  }
}