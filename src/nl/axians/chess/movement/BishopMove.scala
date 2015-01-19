package nl.axians.chess.movement

import nl.axians.chess.pieces.Pawn
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import Math.min
import nl.axians.chess.pieces.Rook
import nl.axians.chess.pieces.Bishop
import Math.abs

class BishopMove(bishop: Bishop, from: Location, to: Location) extends RegularMove(from, to) {
  override def validate(b: Board) =
    abs(deltaX) == abs(deltaY) && b.getOccupiedLocationsBetween(from, to) == Nil
}