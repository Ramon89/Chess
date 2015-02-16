package nl.axians.chess

import nl.axians.chess.game.Board
import nl.axians.chess.movement.Move
import nl.axians.chess.movement.MoveFactory

trait GameListener {
  def boardChanged(newBoard: Board): Unit
  def turnChanged(currentTurn: Color): Unit
  def check(checkedPlayer: Color): Unit
  def checkMate(winner: Color): Unit
}