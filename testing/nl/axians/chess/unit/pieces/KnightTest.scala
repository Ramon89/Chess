package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.Location
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.game.Game
import nl.axians.chess.movement.piece.KnightMove
import nl.axians.chess.White

class KnightTest extends FlatSpec {

  "A knight" should "be able to move a single step" in {
    val g = new Game(new DefaultBoard)
    
    assert(new KnightMove(White, g, Location('B', 1), Location('C', 3)).isValid)
    assert(new KnightMove(White, g, Location('B', 1), Location('A', 3)).isValid)
    assert(!new KnightMove(White, g, Location('B', 1), Location('B', 3)).isValid)
  }
}