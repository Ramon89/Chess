package nl.axians.chess.movement.piece

import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.Color
import nl.axians.chess.movement.RegularMove
import nl.axians.chess.movement.SinglePieceWithStraightLine
import nl.axians.chess.game.Game

class KingMove(c: Color, g: Game, from: Location, to: Location) extends RegularMove(c, g, from, to)
with SinglePieceWithStraightLine {
  
  override def validate = steps == 1
}