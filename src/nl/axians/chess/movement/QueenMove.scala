package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.pieces.Bishop
import nl.axians.chess.pieces.Queen
import nl.axians.chess.pieces.Rook

class QueenMove(queen: Queen, from: Location, to: Location) extends RegularMove(from, to) {
  override def validate(b: Board) ={
    var b1 = new RookMove(Rook(queen.color), from, to).validate(b) 
    var b2 = new BishopMove(Bishop(queen.color), from, to).validate(b)
    
    b1 || b2
  }
}