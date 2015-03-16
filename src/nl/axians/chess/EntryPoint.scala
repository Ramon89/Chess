package nl.axians.chess

import nl.axians.chess.game.DefaultBoard
import nl.axians.chess.game.Game
import nl.axians.chess.gui.Gui
import nl.axians.chess.ai.treesearch.Shannon1948

/**
 * This object serves as the starting point of the application.
 */
object EntryPoint extends App {
  // Create the game.
  val game = new Game(new DefaultBoard)
  
  // Create a GUI.
  val gui = new Gui(game, White)
  game.addListener(gui)
  
  // Create an ai.
  val ai = new Shannon1948(Black, game, 1)
  game.addListener(ai)
  
  // Start the game and GUI.
  game.start
  gui.startup(Array(""))
}