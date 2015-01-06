import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.Location

object Testing_sheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(126); 


  val b = new DefaultBoard;System.out.println("""b  : nl.axians.chess.game.DefaultBoard = """ + $show(b ));$skip(17); 
  
  println(b);$skip(111); 
                                                   
  println(b.movePiece(Location('A', 2), Location('A', 4)));$skip(108); 
 
   println(b.movePiece(Location('A', 2), Location('A', 4)).movePiece(Location('A', 7), Location('A', 5)));$skip(202); 
                                                  
  println(b.movePiece(Location('A', 2), Location('A', 4)).movePiece(Location('A', 7), Location('A', 5)).movePiece(Location('A', 1), Location('A', 3)));$skip(47); 
 

  println("Welcome to the Scala worksheet")}
}
