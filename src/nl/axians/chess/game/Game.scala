package nl.axians.chess.game

import scala.collection.mutable.MutableList
import nl.axians.chess.movement.Move
import nl.axians.chess.White
import nl.axians.chess.Color
import nl.axians.chess.movement.MoveFactory
import nl.axians.chess.Location
import nl.axians.chess.Pawn
import nl.axians.chess.King

class Game(initialBoard: Board) {
  private val boardHistory = MutableList[Board](initialBoard)
  private var currentTurn: Color = White
  
  def getCurrentTurn = currentTurn
  
  /**
   * Returns the current board of this game.
   */
  def getBoard = boardHistory.last
  
  /**
   * Returns a list of possible moves for the given color.
   */
  def getPossibleMoves(color: Color) = { // TODO this has not been tested!
    val occupiedLocations = getBoard.getOccupiedLocations(color)
    val unOccupiedLocations = getBoard.getUnoccupiedLocations(color)
    
    val moves = for {
      from <- occupiedLocations
      to   <- unOccupiedLocations
    } yield MoveFactory.get(this, color, from, to)
    
    moves.filter(m => m.isValid)
  }
  
  /**
   * Returns whether the given location is currently not under attack by a piece of the opponent.
   */
  def isSafe(location: Location, color: Color) = {
    val opponentsLocations = getBoard.getOccupiedLocations(color.opponent)
    val game = new Game(getBoard.setPiece(Pawn(color), location))
    val moves = for (from <- opponentsLocations) yield MoveFactory.get(game, color.opponent, from, location)
    val validAttackingMoves = moves.filter(m => m.isAttack && m.isValid)
    
    validAttackingMoves.size == 0
  }
  
  /**
   * Returns the location of the king of the given color.
   */
  def getKingsLocation(color: Color) = {
    val lambda = (l: Location) => getBoard.getPieceAt(l) == Some(King(color))
    getBoard.getLocations.find(l => lambda(l)) match {
      case Some(location) => location
      case None           => null // TODO throw exception; there is no king??
    }
  }
  
  /**
   * Checks whether the given color is in check.
   */
  def isInCheck(color: Color) = !isSafe(getKingsLocation(color), color)
  
  /**
   * Checks whether the given color is in check mate.
   */
  def isInCheckMate(color: Color) = false
  
  /**
   * Executes the given move or throws an InvalidMoveException if the move is not valid.
   */
  def execute(move: Move): Unit = 
    if(move.isValid) {
      boardHistory += move.execute
      currentTurn = currentTurn.opponent
    } else
      throw new InvalidMoveException("Move " + move + " is not valid") // TODO use i18n
}