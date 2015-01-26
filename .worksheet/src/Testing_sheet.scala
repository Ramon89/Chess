import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.Location
import nl.axians.chess.movement.PawnMove
import nl.axians.chess.pieces.Pawn
import nl.axians.chess.Color._

object Testing_sheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(233); 


  val b = new DefaultBoard;System.out.println("""b  : nl.axians.chess.game.DefaultBoard = """ + $show(b ));$skip(33); 
  
  val pawn = new Pawn(WHITE);System.out.println("""pawn  : nl.axians.chess.pieces.Pawn = """ + $show(pawn ));$skip(72); 
  val pawnMove = new PawnMove(pawn, Location('A', 2), Location('A', 4));System.out.println("""pawnMove  : nl.axians.chess.movement.PawnMove = """ + $show(pawnMove ));$skip(22); val res$0 = 
  pawnMove.isValid(b);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(74); val res$1 = 
  
  
  Location('C', 3) isBetween (Location('D', 1), Location('A', 4));System.out.println("""res1: Boolean = """ + $show(res$1));$skip(45); 

  println("Welcome to the Scala worksheet")}
}
