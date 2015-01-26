package nl.axians.chess.movement

import nl.axians.chess.pieces.Pawn
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import Math.min
import nl.axians.chess.pieces.Rook
import nl.axians.chess.pieces.Bishop
import Math.abs
import nl.axians.chess.Color._

class BishopMove(c: Color, from: Location, to: Location) extends RegularMove(c, from, to) {
  override def validate(b: Board) =
    abs(deltaX) == abs(deltaY) && b.getOccupiedLocationsBetween(from, to) == Nil
}