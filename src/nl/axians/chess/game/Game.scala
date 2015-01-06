package nl.axians.chess.game

import scala.collection.mutable.MutableList

class Game {
  private val boardHistory = MutableList[Board]()
  
//  private var board: Board = new DefaultBoard
//  
//  private[game] def setBoard(board: Board) = this.board = board
  
  /**
   * Returns the current board of this game.
   */
  def getBoard = boardHistory.last
}