import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.Location
import nl.axians.chess.movement.PawnMove
import nl.axians.chess.pieces.Pawn
import nl.axians.chess.Color._

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
  
  val pawn = new Pawn(WHITE)                      //> pawn  : nl.axians.chess.pieces.Pawn = Pw
  val pawnMove = new PawnMove(pawn, Location('A', 2), Location('A', 4))
                                                  //> pawnMove  : nl.axians.chess.movement.PawnMove = nl.axians.chess.movement.Paw
                                                  //| nMove@520a3426
  pawnMove.isValid(b)                             //> res0: Boolean = false
  
  
 

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}