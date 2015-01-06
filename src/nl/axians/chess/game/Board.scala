package nl.axians.chess.game

import nl.axians.chess.Location
import scala.collection.immutable.HashMap
import nl.axians.chess.pieces.AbstractPiece

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
  def isValidLocation(l: Location): Boolean = false
   
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
}

class InvalidLocationException(message: String) extends RuntimeException(message)

class InvalidMoveException(message: String) extends RuntimeException(message)