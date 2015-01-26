package nl.axians.chess.movement

import java.lang.Math.abs
import java.lang.Math.max
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.pieces.King
import nl.axians.chess.pieces.Queen
import nl.axians.chess.Color._

class KingMove(c: Color, from: Location, to: Location) extends RegularMove(c, from, to) {
  override def validate(b: Board) =
    max(abs(deltaX), abs(deltaY)) == 1 && new QueenMove(c, from, to).validate(b)
}