package nl.axians.chess.movement.piece

import nl.axians.chess.Location
import nl.axians.chess.game.Board
import nl.axians.chess.Color._
import nl.axians.chess.movement.RegularMove
import nl.axians.chess.movement.SinglePieceWithStraightLine

class QueenMove(c: Color, b: Board, from: Location, to: Location) extends RegularMove(c, b, from, to) 
with SinglePieceWithStraightLine {
  
  override def validate = isStraightLine
}