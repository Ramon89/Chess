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
import nl.axians.chess.movement.KingMove
import nl.axians.chess.pieces.King

class KingTest extends FlatSpec {

  "The king" should "be able to move like the queen, but with only one step" in {
    var b: Board = new DefaultBoard
    // Move the king to a useful location.
	b = b.movePiece(Location('E', 1), Location('E', 3))
	// The king cannot move to a location that is occupied by its own color.
    assert(!new KingMove(WHITE, Location('E', 3), Location('E', 2)).isValid(b))
    assert(new KingMove(WHITE, Location('E', 3), Location('E', 4)).isValid(b))
    assert(new KingMove(WHITE, Location('E', 3), Location('F', 4)).isValid(b))
  }
}