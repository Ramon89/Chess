package nl.axians.chess.movement

import nl.axians.chess.pieces.Pawn
import nl.axians.chess.Location
import nl.axians.chess.game.Board
import Math.min
import nl.axians.chess.pieces.Rook

class RookMove(rook: Rook, from: Location, to: Location) extends RegularMove(from, to) {
  override def validate(b: Board) =
    deltaX != deltaY && min(deltaX, deltaY) == 0 && b.getOccupiedLocationsBetween(from, to) == Nil
}