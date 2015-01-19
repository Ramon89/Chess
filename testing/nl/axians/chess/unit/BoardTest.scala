package nl.axians.chess.unit

import org.scalatest.FlatSpec
import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.Location
import nl.axians.chess.game.InvalidLocationException
import nl.axians.chess.game.InvalidMoveException

class BoardTest extends FlatSpec {
  "A board" should "allow moving a piece" in {
    val b = new DefaultBoard
    b.movePiece(Location('A', 1), Location('A', 2))
  }
  
  it should "produce InvalidLocationException if either the 'from' or the 'to' location is not valid" in {
	val b = new DefaultBoard
    intercept[InvalidLocationException] {
      b.movePiece(Location('A', 1), Location('A', -1))
    }
    intercept[InvalidLocationException] {
      b.movePiece(Location('A', -1), Location('A', 1))
    }
  }
  
  it should "produce InvalidMoveException if there is no piece at the 'from' location" in {
	val b = new DefaultBoard
    intercept[InvalidMoveException] {
      b.movePiece(Location('A', 3), Location('A', 4))
    }
  }
}