package nl.axians.chess.movement

import java.lang.Math.abs
import java.lang.Math.max
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.pieces.King
import nl.axians.chess.pieces.Queen

class KingMove(king: King, from: Location, to: Location) extends RegularMove(from, to) {
  override def validate(b: Board) =
    max(abs(deltaX), abs(deltaY)) == 1 && new QueenMove(Queen(king.color), from, to).validate(b)
}