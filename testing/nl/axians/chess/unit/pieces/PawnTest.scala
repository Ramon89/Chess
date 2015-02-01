package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.Location
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.PawnMove
import nl.axians.chess.game.Game
import nl.axians.chess.White
import nl.axians.chess.Black

class PawnTest extends FlatSpec {

  "A pawn" should "be able to move a single step" in {
    val g = new Game(new DefaultBoard)
    
    assert(new PawnMove(White, g, Location('A', 2), Location('A', 3)).isValid)
    assert(new PawnMove(White, g, Location('A', 2), Location('A', 4)).isValid)
    assert(!new PawnMove(White, g, Location('A', 2), Location('A', 5)).isValid)
    
    assert(new PawnMove(Black, g, Location('A', 7), Location('A', 6)).isValid)
    assert(new PawnMove(Black, g, Location('A', 7), Location('A', 5)).isValid)
    assert(!new PawnMove(Black, g, Location('A', 7), Location('A', 4)).isValid)    
  }
}