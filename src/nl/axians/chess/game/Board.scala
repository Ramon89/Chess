package nl.axians.chess.game

import nl.axians.chess.Location
import scala.collection.immutable.HashMap
import nl.axians.chess.AbstractPiece
import nl.axians.chess.Color

/**
 * 
 */
abstract class Board {
  private val pieces = getPieces
  
  /**
   * Returns whether the given location is empty.
   */
  def isEmpty(l: Location) = getPieceAt(l) == None
  
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
   * Returns whether there is a piece of the given color on the given location.
   */
  def isPieceOfColorAt(l: Location, c: Color) = getPieceAt(l) match {
      case Some(piece) => piece.color == c
      case None        => false
    }
   
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
  
  /**
   * Sets the given piece on the given location.
   */
  def setPiece(piece: AbstractPiece, location: Location) = newInstance(pieces + Tuple2(location, piece))
  
  /**
   * Returns the locations between the given two locations. The two given locations must form a straight line.
   */
  def getLocationsBetween(l1: Location, l2: Location): List[Location] = 
    getLocations.filter(l => l isBetween (l1, l2))
  
  /**
   * Returns the locations between the given locations for which a function holds (returns true).
   */
  def getLocationsBetween(l1: Location, l2: Location, lambda: Location => Boolean): List[Location] =
    getLocationsBetween(l1, l2).filter(l => lambda(l))
    
  /**
   * Returns the locations between the given locations that are occupied by a piece of any color.
   */
  def getOccupiedLocationsBetween(l1: Location, l2: Location) = getLocationsBetween(l1, l2, l => !isEmpty(l))
  
  /**
   * Returns a list of locations that are occupied by pieces of the given color.
   */
  def getOccupiedLocations(color: Color): List[Location] =
    getLocations.filter(l => getPieceAt(l) match {
      case Some(piece) => piece.color == color
      case None        => false
    })
  
  /**
   * Returns a list of locations that are not occupied by pieces of the given color.
   */
  def getUnoccupiedLocations(color: Color) = getLocations.diff(getOccupiedLocations(color))
  
  /************************************************** ABSTRACT METHODS **************************************************/
  
  /**
   * Returns a list of all the locations of this board.
   */
  def getLocations: List[Location]
  
  /**
   * Determines whether the given location is valid on this board.
   */
  def isValidLocation(l: Location): Boolean
  
  /**
   * Returns a HashMap containing all pieces on this board mapped to a location.
   */
  protected def getPieces: HashMap[Location, AbstractPiece]
  
  /**
   * Returns a new Board instance with the given pieces.
   */
  protected def newInstance(pieces: HashMap[Location, AbstractPiece]): Board
}

class InvalidLocationException(message: String) extends RuntimeException(message)

class InvalidMoveException(message: String) extends RuntimeException(message)