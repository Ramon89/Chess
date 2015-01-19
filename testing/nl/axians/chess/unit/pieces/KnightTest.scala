package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.PawnMove
import nl.axians.chess.pieces.Pawn
import nl.axians.chess.Color._
import nl.axians.chess.Location
import nl.axians.chess.movement.KnightMove
import nl.axians.chess.pieces.Knight

class KnightTest extends FlatSpec {

  "A knight" should "be able to move a single step" in {
    val b = new DefaultBoard
    
    assert(new KnightMove(new Knight(WHITE), Location('B', 1), Location('C', 3)).isValid(b))
    assert(new KnightMove(new Knight(WHITE), Location('B', 1), Location('A', 3)).isValid(b))
    assert(!new KnightMove(new Knight(WHITE), Location('B', 1), Location('B', 3)).isValid(b))
  }
}