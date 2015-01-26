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
import nl.axians.chess.movement.QueenMove
import nl.axians.chess.pieces.Queen

class QueenTest extends FlatSpec {

  "The queen" should "be able to move diagonally" in {
    var b: Board = new DefaultBoard
    
    // A pawn is in the way.
    assert(!new QueenMove(WHITE, Location('D', 1), Location('A', 4)).isValid(b))
    // Move the pawn far away to make room for the queen.
    b = b.movePiece(Location('C', 2), Location('H', 3))
    // The move should now be valid
    assert(new QueenMove(WHITE, Location('D', 1), Location('A', 4)).isValid(b))
  }
  
  it should "be able to move in straight lines as well" in {
    var b: Board = new DefaultBoard
    // Move the queen to another location.
    b = b.movePiece(Location('D', 1), Location('A', 4))
    assert(new QueenMove(WHITE, Location('A', 4), Location('E', 4)).isValid(b))
  }
}