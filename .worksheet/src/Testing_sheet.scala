import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.Location
import nl.axians.chess.game.Game
import nl.axians.chess.White
import nl.axians.chess.Rook

object Testing_sheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(230); 


    val g = new Game(new DefaultBoard);System.out.println("""g  : nl.axians.chess.game.Game = """ + $show(g ));$skip(85); 
    
    val safeLocations = g.getBoard.getLocations.filter(l => g.isSafe(l, White));System.out.println("""safeLocations  : List[nl.axians.chess.Location] = """ + $show(safeLocations ));$skip(112); 
    var actualSafeLocations = (for {
      x <- 'A' to 'H'
      y <- 1 to 4
    } yield Location(x, y)).toList;System.out.println("""actualSafeLocations  : List[nl.axians.chess.Location] = """ + $show(actualSafeLocations ));$skip(69); 
    
    actualSafeLocations = Location('A', 8)::actualSafeLocations;$skip(64); 
    actualSafeLocations = Location('H', 8)::actualSafeLocations;$skip(61); val res$0 = 
    
    safeLocations.toSet.diff(actualSafeLocations.toSet);System.out.println("""res0: scala.collection.immutable.Set[nl.axians.chess.Location] = """ + $show(res$0));$skip(46); 

  println("Welcome to the Scala worksheet")}
}
