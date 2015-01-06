import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.Location

object Testing_sheet {


  val b = new DefaultBoard                        //> b  : nl.axians.chess.game.DefaultBoard = 8   Rb Nb Bb Qb Kb Bb Nb Rb 
                                                  //| 7   Pb Pb Pb Pb Pb Pb Pb Pb 
                                                  //| 6   .  .  .  .  .  .  .  .  
                                                  //| 5   .  .  .  .  .  .  .  .  
                                                  //| 4   .  .  .  .  .  .  .  .  
                                                  //| 3   .  .  .  .  .  .  .  .  
                                                  //| 2   Pw Pw Pw Pw Pw Pw Pw Pw 
                                                  //| 1   Rw Nw Bw Qw Kw Bw Nw Rw
                                                  //| 
                                                  //|     A  B  C  D  E  F  G  H
  
  println(b)                                      //> 8   Rb Nb Bb Qb Kb Bb Nb Rb 
                                                  //| 7   Pb Pb Pb Pb Pb Pb Pb Pb 
                                                  //| 6   .  .  .  .  .  .  .  .  
                                                  //| 5   .  .  .  .  .  .  .  .  
                                                  //| 4   .  .  .  .  .  .  .  .  
                                                  //| 3   .  .  .  .  .  .  .  .  
                                                  //| 2   Pw Pw Pw Pw Pw Pw Pw Pw 
                                                  //| 1   Rw Nw Bw Qw Kw Bw Nw Rw
                                                  //| 
                                                  //|     A  B  C  D  E  F  G  H
                                                   
  println(b.movePiece(Location('A', 2), Location('A', 4)))
                                                  //> 8   Rb Nb Bb Qb Kb Bb Nb Rb 
                                                  //| 7   Pb Pb Pb Pb Pb Pb Pb Pb 
                                                  //| 6   .  .  .  .  .  .  .  .  
                                                  //| 5   .  .  .  .  .  .  .  .  
                                                  //| 4   Pw .  .  .  .  .  .  .  
                                                  //| 3   .  .  .  .  .  .  .  .  
                                                  //| 2   .  Pw Pw Pw Pw Pw Pw Pw 
                                                  //| 1   Rw Nw Bw Qw Kw Bw Nw Rw
                                                  //| 
                                                  //|     A  B  C  D  E  F  G  H
 
   println(b.movePiece(Location('A', 2), Location('A', 4)).movePiece(Location('A', 7), Location('A', 5)))
                                                  //> 8   Rb Nb Bb Qb Kb Bb Nb Rb 
                                                  //| 7   .  Pb Pb Pb Pb Pb Pb Pb 
                                                  //| 6   .  .  .  .  .  .  .  .  
                                                  //| 5   Pb .  .  .  .  .  .  .  
                                                  //| 4   Pw .  .  .  .  .  .  .  
                                                  //| 3   .  .  .  .  .  .  .  .  
                                                  //| 2   .  Pw Pw Pw Pw Pw Pw Pw 
                                                  //| 1   Rw Nw Bw Qw Kw Bw Nw Rw
                                                  //| 
                                                  //|     A  B  C  D  E  F  G  H
                                                  
  println(b.movePiece(Location('A', 2), Location('A', 4)).movePiece(Location('A', 7), Location('A', 5)).movePiece(Location('A', 1), Location('A', 3)))
                                                  //> 8   Rb Nb Bb Qb Kb Bb Nb Rb 
                                                  //| 7   .  Pb Pb Pb Pb Pb Pb Pb 
                                                  //| 6   .  .  .  .  .  .  .  .  
                                                  //| 5   Pb .  .  .  .  .  .  .  
                                                  //| 4   Pw .  .  .  .  .  .  .  
                                                  //| 3   Rw .  .  .  .  .  .  .  
                                                  //| 2   .  Pw Pw Pw Pw Pw Pw Pw 
                                                  //| 1   .  Nw Bw Qw Kw Bw Nw Rw
                                                  //| 
                                                  //|     A  B  C  D  E  F  G  H
 

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}