package nl.axians.chess.game

import scala.collection.mutable.MutableList
import nl.axians.chess.Color
import nl.axians.chess.King
import nl.axians.chess.Location
import nl.axians.chess.Pawn
import nl.axians.chess.White
import nl.axians.chess.movement.Move
import nl.axians.chess.movement.MoveFactory
import nl.axians.chess.Black

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
  def getPossibleMoves(color: Color): List[Move] = {
    val occupiedLocations = getBoard.getOccupiedLocations(color)
    val unOccupiedLocations = getBoard.getUnoccupiedLocations(color)
    
    val moves = for {
      from <- occupiedLocations
      to   <- unOccupiedLocations
    } yield MoveFactory.get(this, from, to)
    
    moves.filter(m => m.isValid)
  }
  
  /**
   * Returns whether the given location is currently not under attack by a piece of the opponent.
   */
  def isSafe(location: Location, color: Color) = {
    if(location == getKingsLocation(color.opponent)) {
      true
    } else {
      val opponentsLocations = getBoard.getOccupiedLocations(color.opponent)
        
      val game = 
          if(getBoard.isPieceOfColorAt(location, color))
            this 
          else 
            new Game(getBoard.setPiece(Pawn(color), location))
    
	    val moves = for (from <- opponentsLocations) yield MoveFactory.get(game, from, location)
	    val validAttackingMoves = moves.filter(m => m.isAttack && m.isValid)
	    
	    validAttackingMoves.size == 0
    }
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
  def isInCheckMate(color: Color) = isInCheck(color) && getPossibleMoves(color) == Nil
  
  /**
   * Executes the given move or throws an InvalidMoveException if the move is not valid.
   */
  def execute(color: Color, move: Move): Unit =
    if(color != currentTurn)
      throw new InvalidMoveException("It's not " + color + "'s turn") // TODO use i18n
    else if(!move.isValid)
      throw new InvalidMoveException("Move " + move + " is not valid") // TODO use i18n
    else {
      boardHistory += move.execute
      currentTurn = currentTurn.opponent
    }
}