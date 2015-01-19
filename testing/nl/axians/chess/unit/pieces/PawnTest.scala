package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.PawnMove
import nl.axians.chess.pieces.Pawn
import nl.axians.chess.Color._
import nl.axians.chess.Location

class PawnTest extends FlatSpec {

  "A pawn" should "be able to move a single step" in {
    val b = new DefaultBoard
    
    assert(new PawnMove(new Pawn(WHITE), Location('A', 2), Location('A', 3)).isValid(b))
    assert(new PawnMove(new Pawn(WHITE), Location('A', 2), Location('A', 4)).isValid(b))
    assert(!new PawnMove(new Pawn(WHITE), Location('A', 2), Location('A', 5)).isValid(b))
    
    assert(new PawnMove(new Pawn(BLACK), Location('A', 7), Location('A', 6)).isValid(b))
    assert(new PawnMove(new Pawn(BLACK), Location('A', 7), Location('A', 5)).isValid(b))
    assert(!new PawnMove(new Pawn(BLACK), Location('A', 7), Location('A', 4)).isValid(b))    
  }
}