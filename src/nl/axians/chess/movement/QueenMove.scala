package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.pieces.Bishop
import nl.axians.chess.pieces.Queen
import nl.axians.chess.pieces.Rook
import nl.axians.chess.Color._

class QueenMove(c: Color, from: Location, to: Location) extends RegularMove(c, from, to) {
  override def validate(b: Board) ={
    var b1 = new RookMove(c, from, to).validate(b) 
    var b2 = new BishopMove(c, from, to).validate(b)
    b1 || b2
  }
}