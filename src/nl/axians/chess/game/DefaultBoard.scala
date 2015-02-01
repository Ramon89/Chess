package nl.axians.chess.game

import nl.axians.chess.Location
import scala.collection.immutable.HashMap
import nl.axians.chess.AbstractPiece
import nl.axians.chess.Knight
import nl.axians.chess.King
import nl.axians.chess.Bishop
import nl.axians.chess.Queen
import nl.axians.chess.Rook
import nl.axians.chess.Pawn
import nl.axians.chess.White
import nl.axians.chess.Black

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
        Location('A', 1) -> Rook(White),
        Location('B', 1) -> Knight(White),
        Location('C', 1) -> Bishop(White),
        Location('D', 1) -> Queen(White),
        Location('E', 1) -> King(White),
        Location('F', 1) -> Bishop(White),
        Location('G', 1) -> Knight(White),
        Location('H', 1) -> Rook(White),
        Location('A', 2) -> Pawn(White),
        Location('B', 2) -> Pawn(White),
        Location('C', 2) -> Pawn(White),
        Location('D', 2) -> Pawn(White),
        Location('E', 2) -> Pawn(White),
        Location('F', 2) -> Pawn(White),
        Location('G', 2) -> Pawn(White),
        Location('H', 2) -> Pawn(White),
        Location('A', 7) -> Pawn(Black),
        Location('B', 7) -> Pawn(Black),
        Location('C', 7) -> Pawn(Black),
        Location('D', 7) -> Pawn(Black),
        Location('E', 7) -> Pawn(Black),
        Location('F', 7) -> Pawn(Black),
        Location('G', 7) -> Pawn(Black),
        Location('H', 7) -> Pawn(Black),
        Location('A', 8) -> Rook(Black),
        Location('B', 8) -> Knight(Black),
        Location('C', 8) -> Bishop(Black),
        Location('D', 8) -> Queen(Black),
        Location('E', 8) -> King(Black),
        Location('F', 8) -> Bishop(Black),
        Location('G', 8) -> Knight(Black),
        Location('H', 8) -> Rook(Black)))
  
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
