package nl.axians.chess.ai

import nl.axians.chess.Color
import nl.axians.chess.game.Game
import nl.axians.chess.GameListener

abstract class AI(val color: Color, protected val game: Game) 
extends AnyRef with GameListener {
  
}