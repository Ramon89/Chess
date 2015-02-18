package nl.axians.chess

import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.game.Game
import nl.axians.chess.gui.Gui
import nl.axians.chess.ai.minimax.Shannon1948

object Start extends App {
  
  val game = new Game(new DefaultBoard)
  
  val gui = new Gui(game, White)
  game.addListener(gui)
  
  val ai = new Shannon1948(Black, game)
  game.addListener(ai)
  
  game.start
  gui.startup(Array(""))
  
//  val gui2 = new Gui(game, Black)
//  game.addListener(gui2)
//  gui2.startup(Array(""))
}