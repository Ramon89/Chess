package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.Color.WHITE
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.KingMove
import nl.axians.chess.game.Game

class KingTest extends FlatSpec {

  "The king" should "be able to move like the queen, but with only one step" in {
    var b: Board = new DefaultBoard
    
    // Move the king to a useful location.
	b = b.movePiece(Location('E', 1), Location('E', 3))
	val g = new Game(b)
	// The king cannot move to a location that is occupied by its own color.
    assert(!new KingMove(WHITE, g, Location('E', 3), Location('E', 2)).isValid)
    assert(new KingMove(WHITE, g, Location('E', 3), Location('E', 4)).isValid)
    assert(new KingMove(WHITE, g, Location('E', 3), Location('F', 4)).isValid)
  }
}