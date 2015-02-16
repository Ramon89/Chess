package nl.axians.chess

import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.game.Game
import nl.axians.chess.gui.Gui

object Start extends App {
  
//  val game = new Game(new DefaultBoard)
//  game.addListener(Gui)
//  Gui.setView(Black)
//  Gui.setGame(game)
//  Gui.startup(Array(""))
  
  val game = new Game(new DefaultBoard)
  val gui = new Gui(game, White)
  game.addListener(gui)
  gui.startup(Array(""))
  
  val gui2 = new Gui(game, Black)
  game.addListener(gui2)
  gui2.startup(Array(""))
}