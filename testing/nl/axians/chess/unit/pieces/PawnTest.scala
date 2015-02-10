package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.Location
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.PawnMove
import nl.axians.chess.game.Game
import nl.axians.chess.White
import nl.axians.chess.Black
import nl.axians.chess.movement.piece.SingleStepPawnMove
import nl.axians.chess.movement.piece.DoubleStepPawnMove
import nl.axians.chess.movement.MoveFactory

class PawnTest extends FlatSpec {

  "A pawn" should "be able to move a single step" in {
    val g = new Game(new DefaultBoard)
    assert(MoveFactory.get(g, Location('A', 2), Location('A', 3)).isValid)
    assert(MoveFactory.get(g, Location('A', 7), Location('A', 6)).isValid)
  }
  
  it should "be able to do a double step from its starting position" in {
    val g = new Game(new DefaultBoard)
    assert(MoveFactory.get(g, Location('A', 2), Location('A', 4)).isValid)
    assert(!MoveFactory.get(g, Location('A', 2), Location('A', 5)).isValid)
    assert(MoveFactory.get(g, Location('A', 7), Location('A', 5)).isValid)
    assert(!MoveFactory.get(g, Location('A', 7), Location('A', 4)).isValid) 
  }
  
  // TODO add test for pawn attack
  // TODO add test for pawn promotion
}