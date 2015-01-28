package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec

import nl.axians.chess.Color.WHITE
import nl.axians.chess.Location
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.KnightMove

class KnightTest extends FlatSpec {

  "A knight" should "be able to move a single step" in {
    val b = new DefaultBoard
    
    assert(new KnightMove(WHITE, b, Location('B', 1), Location('C', 3)).isValid)
    assert(new KnightMove(WHITE, b, Location('B', 1), Location('A', 3)).isValid)
    assert(!new KnightMove(WHITE, b, Location('B', 1), Location('B', 3)).isValid)
  }
}