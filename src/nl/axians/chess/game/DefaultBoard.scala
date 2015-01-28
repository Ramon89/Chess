package nl.axians.chess.game

import nl.axians.chess.Location
import nl.axians.chess.Color._
import scala.collection.immutable.HashMap
import nl.axians.chess.AbstractPiece
import nl.axians.chess.Knight
import nl.axians.chess.King
import nl.axians.chess.Bishop
import nl.axians.chess.Queen
import nl.axians.chess.Rook
import nl.axians.chess.Pawn

/**
 * This class represents the default starting board of a regular chess game.
 */
class DefaultBoard(pieces: HashMap[Location, AbstractPiece]) extends Board {
  /**
   * The reason that y comes before x and the y range is reversed, is to allow this list to start with A8, which is the
   * top-left of a chess board.
   */
  private val locations = (for(y <- (1 to 8).reverse; x <- 'A' to 'H') yield Location(x, y))
  
  /**
   * Use this constructor to create an initial DefaultBoard.
   */
  def this() = 
    this(HashMap[Location, AbstractPiece](
        Location('A', 1) -> Rook(WHITE),
        Location('B', 1) -> Knight(WHITE),
        Location('C', 1) -> Bishop(WHITE),
        Location('D', 1) -> Queen(WHITE),
        Location('E', 1) -> King(WHITE),
        Location('F', 1) -> Bishop(WHITE),
        Location('G', 1) -> Knight(WHITE),
        Location('H', 1) -> Rook(WHITE),
        Location('A', 2) -> Pawn(WHITE),
        Location('B', 2) -> Pawn(WHITE),
        Location('C', 2) -> Pawn(WHITE),
        Location('D', 2) -> Pawn(WHITE),
        Location('E', 2) -> Pawn(WHITE),
        Location('F', 2) -> Pawn(WHITE),
        Location('G', 2) -> Pawn(WHITE),
        Location('H', 2) -> Pawn(WHITE),
        Location('A', 7) -> Pawn(BLACK),
        Location('B', 7) -> Pawn(BLACK),
        Location('C', 7) -> Pawn(BLACK),
        Location('D', 7) -> Pawn(BLACK),
        Location('E', 7) -> Pawn(BLACK),
        Location('F', 7) -> Pawn(BLACK),
        Location('G', 7) -> Pawn(BLACK),
        Location('H', 7) -> Pawn(BLACK),
        Location('A', 8) -> Rook(BLACK),
        Location('B', 8) -> Knight(BLACK),
        Location('C', 8) -> Bishop(BLACK),
        Location('D', 8) -> Queen(BLACK),
        Location('E', 8) -> King(BLACK),
        Location('F', 8) -> Bishop(BLACK),
        Location('G', 8) -> Knight(BLACK),
        Location('H', 8) -> Rook(BLACK)))
  
  override def getPieces = pieces
  
  override def getLocations = locations.toList
  
  override def isValidLocation(l: Location) = locations.contains(l)
  
  override def newInstance(pieces: HashMap[Location, AbstractPiece]) = new DefaultBoard(pieces)
  
  override def toString = {
    def printablePiece(l: Location) = getPieceAt(l) match {
      case Some(piece) => piece.toString
      case None        => ". "
    }
    
    val l = for(l <- locations) yield {
        if(l.x == 'A')
          (if(l.y != 8) "\n" + l.y + "   " else l.y + "   ") +
          printablePiece(l)
        else 
          "" + printablePiece(l)
    }
    l.mkString(" ") + "\n\n    A  B  C  D  E  F  G  H"
  }
}
