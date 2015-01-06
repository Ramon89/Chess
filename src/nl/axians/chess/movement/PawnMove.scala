package nl.axians.chess.movement

import nl.axians.chess.Location
import nl.axians.chess.pieces.Pawn
import nl.axians.chess.game.Board

class PawnMove(pawn: Pawn, from: Location, to: Location) extends RegularMove(from, to) {
  override def doApply(b: Board) = 0 // TODO do the magic!
}