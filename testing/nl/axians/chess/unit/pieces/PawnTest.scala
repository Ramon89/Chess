package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.Color.BLACK
import nl.axians.chess.Color.WHITE
import nl.axians.chess.Location
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.PawnMove
import nl.axians.chess.game.Game

class PawnTest extends FlatSpec {

  "A pawn" should "be able to move a single step" in {
    val b = new DefaultBoard
    val g = new Game
    
    assert(new PawnMove(WHITE, b, g, Location('A', 2), Location('A', 3)).isValid)
    assert(new PawnMove(WHITE, b, g, Location('A', 2), Location('A', 4)).isValid)
    assert(!new PawnMove(WHITE, b, g, Location('A', 2), Location('A', 5)).isValid)
    
    assert(new PawnMove(BLACK, b, g, Location('A', 7), Location('A', 6)).isValid)
    assert(new PawnMove(BLACK, b, g, Location('A', 7), Location('A', 5)).isValid)
    assert(!new PawnMove(BLACK, b, g, Location('A', 7), Location('A', 4)).isValid)    
  }
}