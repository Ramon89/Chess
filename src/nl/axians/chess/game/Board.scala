package nl.axians.chess.game

import nl.axians.chess.Location
import scala.collection.immutable.HashMap
import nl.axians.chess.AbstractPiece

/**
 * 
 */
abstract class Board {
  private val pieces = getPieces
  
  /**
   * Returns a HashMap containing all pieces on this board mapped to a location.
   */
  protected def getPieces: HashMap[Location, AbstractPiece]
  
  /**
   * Returns a new Board instance with the given pieces.
   */
  protected def newInstance(pieces: HashMap[Location, AbstractPiece]): Board
  
  /**
   * Determines whether the given location is valid on this board.
   */
  def isValidLocation(l: Location): Boolean // TODO: why is this not yet implemented??
  
  /**
   * Returns whether the given location is empty.
   */
  def isEmpty(l: Location) = getPieceAt(l) == None
   
  /**
   * Returns a list of all the locations of this board.
   */
  def getLocations: List[Location]
  
  /**
   * Returns the piece at a given location, or None if there is no piece on that location.
   */
  def getPieceAt(l: Location): Option[AbstractPiece] =
    if(pieces.contains(l))
	  pieces.get(l)
    else if(!isValidLocation(l))
      throw new InvalidLocationException("Invalid location " + l + " for this Board") // TODO use I18N
    else
      None
   
  /**
   * Moves the piece on the given location to another location, creating a new Board instance.
   */
  def movePiece(from: Location, to: Location): Board =
    getPieceAt(from) match {
      case Some(piece) => 
        if(!isValidLocation(to))
          throw new InvalidLocationException("Invalid location " + to + " for this Board") // TODO use I18N
        // Remove old location and add the new location with the piece.
        newInstance(pieces - from + Tuple2(to, piece))
      case None        => 
        throw new InvalidMoveException("There is no piece to move from " + from) // TODO use I18N
    }
  
  def getLocationsBetween(l1: Location, l2: Location): List[Location] = {
    for {
      l <- getLocations
      if l isBetween (l1, l2)
    } yield l
  }
  
  def getLocationsBetween(l1: Location, l2: Location, lambda: Location => Boolean): List[Location] =
    for{
      l <- getLocationsBetween(l1, l2)
      if lambda(l)
    } yield l
    
  def getOccupiedLocationsBetween(l1: Location, l2: Location) = getLocationsBetween(l1, l2, l => !isEmpty(l))
}

class InvalidLocationException(message: String) extends RuntimeException(message)

class InvalidMoveException(message: String) extends RuntimeException(message)