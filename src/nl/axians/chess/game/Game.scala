package nl.axians.chess.game

import scala.collection.mutable.MutableList

import nl.axians.chess.movement.AbstractMove

class Game(initialBoard: Board) {
  private val boardHistory = MutableList[Board](initialBoard)
  
  /**
   * Returns the current board of this game.
   */
  def getBoard = boardHistory.last
  
  
  
  
  /**
   * Executes the given move or throws an InvalidMoveException if the move is not valid.
   */
  def execute(move: AbstractMove): Unit = 
    if(move.isValid)
      boardHistory += move.execute
    else
      throw new InvalidMoveException("Move " + move + " is not valid") // TODO use i18n
}