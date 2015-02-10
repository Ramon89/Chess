package nl.axians.chess.unit.pieces

import org.scalatest.FlatSpec
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.movement.piece.RookMove
import nl.axians.chess.game.Game
import nl.axians.chess.White
import nl.axians.chess.game.DefaultBoard

class RookTest extends FlatSpec {

  "A rook" should "be able to move a straight lines" in {
    var b: Board = new DefaultBoard
    var g = new Game(b)
    
    // A pawn is in the way.
    assert(!new RookMove(White, g, Location('A', 1), Location('A', 3)).isValid)
    // Move the pawn far away to make room for the rook.
    b = b.movePiece(Location('A', 2), Location('H', 3))
    g = new Game(b)
    // The move should now be valid
    assert(new RookMove(White, g, Location('A', 1), Location('A', 3)).isValid)
    b = b.movePiece(Location('A', 1), Location('A', 3))
    g = new Game(b)
    // Non-straight lines are invalid.
    assert(!new RookMove(White, g, Location('A', 3), Location('H', 4)).isValid)
  }
  
  it can "not move to a location that is already taken by a piece with the same color" in {
    val g = new Game(new DefaultBoard)
    assert(!new RookMove(White, g, Location('A', 1), Location('A', 2)).isValid)
    assert(!new RookMove(White, g, Location('A', 1), Location('B', 1)).isValid)
  }
  
  it can "not move to a location that would cause this color to be in check" in {
    var b: Board = new DefaultBoard
    b = b.movePiece(Location('E', 1), Location('H', 3))
    b = b.movePiece(Location('A', 1), Location('G', 3))
    b = b.movePiece(Location('A', 8), Location('A', 3))
    val g = new Game(b)
    
    // The following move is valid, as the defending rook moves towards the attacker.
    assert(new RookMove(White, g, Location('G', 3), Location('F', 3)).isValid)
    // The next move is invalid, as it would cause check.
    assert(!new RookMove(White, g, Location('G', 3), Location('G', 4)).isValid)
  } 
}